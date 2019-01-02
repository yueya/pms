package com.yueya.system.controller;

import com.yueya.auth.config.AuthProperties;
import com.yueya.auth.utils.UserInfoUtil;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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
        String exception = (String) request.getAttribute("shiroLoginFailure");
        RestResult result;
        System.out.println(exception);
        if(exception!=null){
            if (UnknownAccountException.class.getName().equals(exception)) {
                result=RestResult.ERROR("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                result=RestResult.ERROR("用户或密码错误");
            } else if ("kaptchaValidateFailed".equals(exception)) {
                result=RestResult.ERROR("验证码错误");
            } else {
                result=RestResult.ERROR(exception);
            }
            return result;
        }
        return RestResult.ERROR("未登录,请先登录");
    }

}
