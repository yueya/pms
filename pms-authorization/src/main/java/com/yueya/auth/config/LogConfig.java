package com.yueya.auth.config;

import com.yueya.auth.log.LogInterceptor;
import com.yueya.auth.log.LogMessagePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yueya.auth.config.AuthConstant.LOG_CHANNEL;

@Configuration
@Import(JedisConfig.class)
public class LogConfig implements WebMvcConfigurer{
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private AuthProperties properties;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired(required = false)
    MessageListener listener;
    @Autowired
    private LogInterceptor logInterceptor;
    @Bean
    RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        if("server".equals(properties.getType())){
            if(listener==null){
                throw new NullPointerException("未实现org.springframework.data.redis.connection.MessageListener");
            }
            MessageListenerAdapter adapter=new MessageListenerAdapter(listener);
            container.addMessageListener(adapter, new ChannelTopic(LOG_CHANNEL));
        }
        return container;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns= Stream.of(
                properties.getAdminPath()+"/**"
               // properties.getLoginUrl()
                        )
                .collect(Collectors.toList());
        registry.addInterceptor(logInterceptor).addPathPatterns(patterns);
        logger.info("log interceptor");
    }

    @Bean
    LogMessagePublisher redisPublisher() {
        return new LogMessagePublisher(redisTemplate,new ChannelTopic(LOG_CHANNEL));
    }
}
