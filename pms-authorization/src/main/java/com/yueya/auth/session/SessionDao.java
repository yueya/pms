package com.yueya.auth.session;

import com.yueya.common.web.RestPage;
import org.apache.shiro.session.mgt.eis.SessionDAO;

public interface SessionDao extends SessionDAO {

    public RestPage getActiveSessions(int offset, int limit);

    public void forceOut(String ids);
}
