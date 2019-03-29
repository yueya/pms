package com.yueya.auth.session;

import com.yueya.auth.utils.RequestUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

public class PmsSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext sessionContext) {
        if (sessionContext != null) {
            HttpServletRequest request =  WebUtils.getHttpRequest(sessionContext);
            String host = RequestUtil.getRemoteAddr(request);
            if (host != null) {
                return new SimpleSession(host);
            }
        }
        return new SimpleSession();
    }
}
