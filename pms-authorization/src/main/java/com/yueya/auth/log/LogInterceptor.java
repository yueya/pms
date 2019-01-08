package com.yueya.auth.log;

import com.yueya.auth.realm.Principal;
import com.yueya.auth.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class LogInterceptor implements HandlerInterceptor{
    @Autowired
    private LogService logService;
    private ThreadPoolExecutor threadPool= new ThreadPoolExecutor(5, 100,
            500L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Principal principal=UserInfoUtil.getPrincipal();
        threadPool.execute(()-> logService.saveLog(request,handler,ex,principal,null));
    }
}
