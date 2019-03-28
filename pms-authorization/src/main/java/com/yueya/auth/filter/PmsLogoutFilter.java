package com.yueya.auth.filter;

import com.yueya.common.util.JsonMapper;
import com.yueya.common.web.RestResult;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Writer;
import java.util.Locale;

public class PmsLogoutFilter extends LogoutFilter {

    Logger logger= LoggerFactory.getLogger(getClass());
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = this.getSubject(request, response);
        if (this.isPostOnlyLogout() && !WebUtils.toHttp(request).getMethod().toUpperCase(Locale.ENGLISH).equals("POST")) {
            return this.onLogoutRequestNotAPost(request, response);
        } else {
            try {
                subject.logout();
                String msg= JsonMapper.toJsonString(RestResult.OK("登出成功"));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                Writer writer=response.getWriter();
                writer.write(msg);
                writer.flush();
                writer.close();
            } catch (SessionException var6) {
                logger.debug("Encountered session exception during logout.  This can generally safely be ignored.", var6);
            }
            return false;
        }
    }
}
