package com.yueya.auth.log;

import com.yueya.auth.model.PmsLog;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

public class LogMessagePublisher{
    private RedisTemplate<String, Object> redisTemplate;
    private ChannelTopic topic;

    public void publish(PmsLog message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
    public LogMessagePublisher(RedisTemplate<String, Object> redisTemplate,ChannelTopic topic){
        this.redisTemplate=redisTemplate;
        this.topic=topic;
    }

}
