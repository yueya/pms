package com.yueya.system.controller;

import com.yueya.auth.config.AuthProperties;
import com.yueya.auth.utils.UserInfoUtil;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.yueya.auth.config.AuthConstant.LOGIN_FAIL_MESSAGE;

//@RequestMapping("${auth.adminPath}")
@RestController
public class LoginController extends BaseController {

    @Autowired
    private AuthProperties properties;
    @RequestMapping("login")
    public RestResult login(HttpServletRequest request){
        if(UserInfoUtil.getPrincipal()!=null){
            return RestResult.OK("已登录");
        }
        String message = (String) request.getAttribute(LOGIN_FAIL_MESSAGE);
        if(message!=null){
            return RestResult.ERROR(message);
        }
        return RestResult.ERROR("未登录,请先登录");
    }

}
