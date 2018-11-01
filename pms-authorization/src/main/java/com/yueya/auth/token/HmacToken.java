package com.yueya.auth.token;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.Map;

public class HmacToken implements AuthenticationToken {
    // 客户标识（可以是用户名、app id等等）
    private String clientKey;
    // 消息摘要
    private String digest;
    // 时间戳
    private String timeStamp;
    // 访问参数
    private Map<String, String[]> parameters;
    // 客户端IP
    private String host;
    public HmacToken(String clientKey,String timeStamp,String digest
            ,String host,Map<String, String[]> parameters){
        this.clientKey = clientKey;
        this.timeStamp = timeStamp;
        this.digest = digest;
        this.host = host;
        this.parameters = parameters;
    }
    @Override
    public Object getPrincipal() {
        return this.clientKey;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
