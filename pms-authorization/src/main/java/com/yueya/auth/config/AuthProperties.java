package com.yueya.auth.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth")
public class AuthProperties {
    /**
     * 默认拦截
     */
    private String adminPath=null;
    /**
     * 默认不拦截
     */

    private String frontPath=null;

    private String successUrl=null;

    private String type=null;
    /**
     * 认证的模式：normal/jwt/sso 默认是normal
     */
    private String mode="normal";

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String loginUrl=null;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public  String getAdminPath() {
        return adminPath;
    }

    public  void setAdminPath(String adminPath) {
        this.adminPath = adminPath;
    }

    public  String getFrontPath() {
        return frontPath;
    }

    public  void setFrontPath(String frontPath) {
        this.frontPath = frontPath;
    }

    public  String getSuccessUrl() {
        return successUrl;
    }

    public  void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }
}
