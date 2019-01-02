package com.yueya.common.base;


import com.yueya.common.web.RestResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
public class BaseController {

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
        e.printStackTrace();
       return RestResult.ERROR(e.getMessage());
    }
}
