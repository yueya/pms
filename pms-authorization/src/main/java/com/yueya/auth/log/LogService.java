package com.yueya.auth.log;

import com.yueya.auth.config.AuthProperties;
import com.yueya.auth.model.PmsLog;
import com.yueya.auth.realm.Principal;
import com.yueya.auth.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LogService {

    @Autowired
    private LogMessagePublisher messagePublisher;
    @Autowired
    private AuthProperties properties;
    public void saveLog(HttpServletRequest request, Object handler, Exception ex, Principal principal, String title){
        PmsLog log=new PmsLog();
        log.setTitle(title);
        log.setAppId(properties.getAppId());
        log.setMethod(request.getMethod());
        if(request.getParameterMap()!=null){
            StringBuilder params = new StringBuilder();
            request.getParameterMap()
                    .forEach((k,v)->{
                        params.append(k+"="+Stream.of(v).collect(Collectors.joining(","))).append("&");
                    });
            log.setParams(params.toString());
        }
        log.setRemoteAddress(RequestUtil.getRemoteAddr(request));
        log.setRequestUri(request.getRequestURI());
        log.setUserAgent(request.getHeader("user-agent"));
        log.setUserName(principal.getUserName());
        if(ex==null){
            log.setType(PmsLog.TYPE_ACCESS);
        }else{
            log.setException(ex.getMessage());
            log.setType(PmsLog.TYPE_EXCEPTION);
        }
        messagePublisher.publish(log);
    }
}
