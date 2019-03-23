package com.yueya.common.base;


import com.yueya.common.util.DateUtils;
import com.yueya.common.web.RestResult;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseController {
    protected Logger logger= LoggerFactory.getLogger(getClass());
    /**
     * 不需要验证的接口的根路径
     */
    @Value("${auth.frontPath}")
    protected String frontPath;
    /**
     * 后台管理接口的根路径
     */
    @Value("${auth.adminPath}")
    protected String adminPath;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RestResult ExceptionHandler(Exception e ){
       logger.error("controller异常",e);
       if(logger.isDebugEnabled()){
           return RestResult.ERROR(e.getMessage());
       }else{
           return RestResult.ERROR("error!please check log");
       }
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class})
    public RestResult ValidExceptionHandler(ConstraintViolationException e ){
        logger.error("参数异常",e);
        String msg = e.getConstraintViolations().stream()
                .map(r -> r.getPropertyPath().toString() + ":" + r.getMessage())
                .collect(Collectors.joining(";"));
        return RestResult.ERROR(msg);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public RestResult ValidExceptionHandler(MethodArgumentNotValidException e ){
        logger.error("参数异常",e);
        String msg = e.getBindingResult().getAllErrors().stream()
                .filter(r -> r instanceof FieldError)
                .map(r -> ((FieldError)r).getField()+":"+ r.getDefaultMessage())
                .collect(Collectors.joining(";"));
        return RestResult.ERROR(msg);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({BindException.class})
    public RestResult ValidExceptionHandler(BindException e ){
        logger.error("参数异常",e);
        String msg = e.getBindingResult().getAllErrors().stream()
                .filter(r -> r instanceof FieldError)
                .map(r -> ((FieldError)r).getField()+":"+ r.getDefaultMessage())
                .collect(Collectors.joining(";"));
        return RestResult.ERROR(msg);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }
}
