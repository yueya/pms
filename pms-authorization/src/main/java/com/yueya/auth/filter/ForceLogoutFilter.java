package com.yueya.auth.filter;

import com.yueya.auth.config.AuthConstant;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ForceLogoutFilter extends AccessControlFilter {
    Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Session session=getSubject(request,response).getSession(false);
        if(session==null){
            return true;
        }
        return session.getAttribute(AuthConstant.FORCE_LOGOUT_KEY)==null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        try {
            getSubject(request,response).logout();
        }catch (Exception e){
            logger.error("force logout error",e);
        }
        return false;
    }
}
