package com.yueya.auth.filter;

import com.yueya.common.util.JsonMapper;
import com.yueya.common.web.RestResult;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

public class PmsUserFilter extends UserFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //return super.onAccessDenied(request, response);
        System.out.println("asd");
        HttpServletResponse httpServletResponse= (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        /*String msg= JsonMapper.toJsonString(RestResult.ERROR("未登录"));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Writer writer=response.getWriter();
        writer.write(msg);
        writer.flush();
        writer.close();*/
        return false;
    }
}
