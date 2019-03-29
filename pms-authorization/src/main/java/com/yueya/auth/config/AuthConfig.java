package com.yueya.auth.config;
import com.yueya.auth.cache.PmsCacheManager;
import com.yueya.auth.filter.AccountFilter;
import com.yueya.auth.filter.ForceLogoutFilter;
import com.yueya.auth.filter.PmsLogoutFilter;
import com.yueya.auth.filter.PmsUserFilter;
import com.yueya.auth.realm.AccountRealm;
import com.yueya.auth.realm.CookieTokenRealm;
import com.yueya.auth.service.AccountInfoProvider;
import com.yueya.auth.session.PmsSessionDao;
import com.yueya.auth.session.PmsSessionFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(AuthProperties.class)
@Import(LogConfig.class)
public class AuthConfig {
    @Autowired
    private AuthProperties properties;
    @Autowired(required = false)
    private AccountInfoProvider provider;
    @Autowired
    private PmsSessionDao sessionDao;
    @Autowired
    private PmsCacheManager cacheManager;
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
        SessionFactory sessionFactory = new PmsSessionFactory();
        sessionManager.setSessionFactory(sessionFactory);
        sessionManager.setSessionDAO(sessionDao);
        securityManager.setSessionManager(sessionManager);
        AccountRealm realm=new AccountRealm();
        realm.setCachingEnabled(true);
        realm.setAuthenticationCachingEnabled(true);
        realm.setCacheManager(cacheManager);
        realm.setProperties(properties);
        if(properties.getType().equals("server")){
            if(provider==null){
                throw new NullPointerException("未实现AccountInfoProvider");
            }
            realm.setProvider(provider);
            realm.setMessageConfig(MessageConfig.ins());
        }
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilters(SecurityManager manager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String,String> filters=new HashMap<>();
        filters.put(properties.getAdminPath()+"/logout","logout");
        filters.put(properties.getAdminPath()+"/**","forceLogout,user");
        filters.put(properties.getFrontPath()+"/**","anon");
        filters.put(properties.getLoginUrl(),"authc");
        shiroFilterFactoryBean.setLoginUrl(properties.getLoginUrl());
        shiroFilterFactoryBean.setSuccessUrl(properties.getSuccessUrl());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filters);
        shiroFilterFactoryBean.setSecurityManager(manager);
        shiroFilterFactoryBean.getFilters().put("authc",new AccountFilter());
        shiroFilterFactoryBean.getFilters().put("user",new PmsUserFilter());
        shiroFilterFactoryBean.getFilters().put("forceLogout",new ForceLogoutFilter());
        shiroFilterFactoryBean.getFilters().put("logout",new PmsLogoutFilter());
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;

    }

}
