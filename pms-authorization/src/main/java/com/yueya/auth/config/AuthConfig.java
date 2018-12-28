package com.yueya.auth.config;
import com.yueya.auth.realm.AccountRealm;
import com.yueya.auth.realm.CookieTokenRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(AuthProperties.class)
public class AuthConfig {
    @Autowired
    private AuthProperties properties;
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        if(properties.getType().equals("server")){
            securityManager.setRealm(new AccountRealm());
        }else{
            securityManager.setRealm(new CookieTokenRealm());
        }
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilters(SecurityManager manager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String,String> filters=new HashMap<>();
        filters.put("/logout","logout");
        filters.put(properties.getAdminPath()+"/**","user");
        filters.put(properties.getFrontPath()+"/**","anon");
        shiroFilterFactoryBean.setLoginUrl(properties.getLoginUrl());
        shiroFilterFactoryBean.setSuccessUrl(properties.getSuccessUrl());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filters);
        shiroFilterFactoryBean.setSecurityManager(manager);
        return shiroFilterFactoryBean;
    }

}
