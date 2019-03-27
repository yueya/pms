package com.yueya.auth.log;

import com.yueya.auth.realm.Principal;
import com.yueya.auth.utils.UserInfoUtil;
import com.yueya.common.web.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class LogInterceptor implements HandlerInterceptor, HandlerExceptionResolver {
    protected Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private LogService logService;
    private ThreadPoolExecutor threadPool= new ThreadPoolExecutor(5, 100,
            500L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Principal principal=UserInfoUtil.getPrincipal();
        threadPool.execute(()-> logService.saveLog(request,handler,null,principal,null));
        return true;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        RestResult result;
        String msg;
        if (e instanceof ConstraintViolationException) {
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            ConstraintViolationException ex = (ConstraintViolationException)e;
            msg = ex.getConstraintViolations().stream()
                    .map(r -> r.getPropertyPath().toString() + ":" + r.getMessage())
                    .collect(Collectors.joining(";"));
        } else if (e instanceof MethodArgumentNotValidException) {
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            msg = ex.getBindingResult().getAllErrors().stream()
                    .filter(r -> r instanceof FieldError)
                    .map(r -> ((FieldError)r).getField()+":"+ r.getDefaultMessage())
                    .collect(Collectors.joining(";"));
        } else if(e instanceof BindException) {
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            BindException ex = (BindException) e;
            msg = ex.getBindingResult().getAllErrors().stream()
                    .filter(r -> r instanceof FieldError)
                    .map(r -> ((FieldError)r).getField()+":"+ r.getDefaultMessage())
                    .collect(Collectors.joining(";"));
        } else {
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("controller异常",e);
            if(logger.isDebugEnabled()){
                msg = e.getMessage();
            }else{
                msg = "error!please check log";
            }
        }
        Principal principal=UserInfoUtil.getPrincipal();
        threadPool.execute(()-> logService.saveLog(httpServletRequest,null,e,principal,null));
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        mv.setView(view);
        mv.addObject("code",500);
        mv.addObject("msg",msg);
        return mv;
    }
}
