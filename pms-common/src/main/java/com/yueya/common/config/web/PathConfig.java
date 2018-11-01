package com.yueya.common.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="auth")
public class PathConfig {
    /**
     * 默认拦截
     */
    @Value("${adminPath}")
    public static String adminPath;
    /**
     * 默认不拦截
     */
    @Value("${frontPath}")
    public static String frontPath;

    @Value("$(successUrl")
    public static String successUrl;
}
