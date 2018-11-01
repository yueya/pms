package com.yueya.auth.token;

import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken {
    /**
     * json web token
     */
    private String jwt;
    /**
     * 客户端IP
     */
    private String host;
    public JwtToken(String jwt,String host){
        this.jwt = jwt;
        this.host = host;
    }
    @Override
    public Object getPrincipal() {
        return this.jwt;
    }

    @Override
    public Object getCredentials() {
        return Boolean.TRUE;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
