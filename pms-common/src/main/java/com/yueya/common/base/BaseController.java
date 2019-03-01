package com.yueya.common.base;


import com.yueya.common.web.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
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
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RestResult ExceptionHandler(Exception e ){
       logger.error("controller异常",e);
       if(logger.isDebugEnabled()){
           return RestResult.ERROR(e.getMessage());
       }else{
           return RestResult.ERROR("后台异常,请查看日志");
       }
    }
}
