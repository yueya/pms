package com.yueya.auth.config;
import com.yueya.common.config.web.PathConfig;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AuthConfig {
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(null);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilters(SecurityManager manager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String,String> filters=new HashMap<>();
        filters.put("/logout","logout");
        filters.put(PathConfig.adminPath,"user");
        filters.put(PathConfig.frontPath,"anon");
        shiroFilterFactoryBean.setLoginUrl("login");
        shiroFilterFactoryBean.setSuccessUrl(PathConfig.successUrl);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filters);
        shiroFilterFactoryBean.setSecurityManager(manager);
        return shiroFilterFactoryBean;
    }

}
