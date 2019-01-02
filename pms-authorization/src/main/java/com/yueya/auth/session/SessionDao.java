package com.yueya.auth.session;

import com.yueya.auth.model.SessionPage;
import org.apache.shiro.session.mgt.eis.SessionDAO;

import java.util.List;

public interface SessionDao extends SessionDAO {

    public SessionPage getActiveSessions(int offset, int limit);

    public void forceOut(String ids);
}
