package com.yueya.auth.filter;

import com.yueya.common.web.RestResult;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static com.yueya.auth.config.AuthConstant.LOGIN_FAIL_MESSAGE;

public class AccountFilter extends FormAuthenticationFilter {
    private Logger logger= LoggerFactory.getLogger(getClass());
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        if (password==null){
            password = "";
        }
        boolean rememberMe = isRememberMe(request);
        return new UsernamePasswordToken(username, password.toCharArray(), rememberMe);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ex, ServletRequest request, ServletResponse response) {
        String exception=ex.getClass().getName();
        String result=null;
        if (UnknownAccountException.class.getName().equals(exception)) {
            result= "账号不存在";
        } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
            result="用户或密码错误";
        } else if ("kaptchaValidateFailed".equals(exception)) {
            result="验证码错误";
        } else {
            result=ex.getMessage();
        }
        if(logger.isDebugEnabled()){
            logger.error("登录异常",exception);
        }
        request.setAttribute(LOGIN_FAIL_MESSAGE,result);
        return true;
    }
}
