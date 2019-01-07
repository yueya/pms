package com.yueya.auth.log;

import com.yueya.auth.realm.Principal;
import com.yueya.auth.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LogInterceptor implements HandlerInterceptor{
    @Autowired
    private LogService logService;
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Principal principal=UserInfoUtil.getPrincipal();
        logService.saveLog(request,handler,ex,principal,null);
    }
}
