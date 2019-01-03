package com.yueya.system.controller;

import com.yueya.auth.config.AuthConstant;
import com.yueya.auth.model.SessionPage;
import com.yueya.auth.session.SessionDao;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${auth.adminPath}/session")
public class SessionController extends BaseController {

    @Autowired
    private SessionDao sessionDao;
    //@RequiresPermissions("user:admin")
    @RequestMapping("list")
    public RestResult listActiveSessions(@RequestParam(name = "limit",defaultValue = "10") int limit,
                                         @RequestParam(name = "offset",defaultValue = "0") int offset){
        SessionPage page=sessionDao.getActiveSessions(offset,limit);
        return RestResult.OkWithData(page);
    }
    @RequestMapping("forcelogout")
    public RestResult forceLogout(String sessionId){
        try {
            Session session=sessionDao.readSession(sessionId);
            session.setAttribute(AuthConstant.FORCE_LOGOUT_KEY,true);
            return RestResult.OK("success");
        } catch (UnknownSessionException e) {
            logger.error("forceLogout err",e);
            return RestResult.ERROR("error");
        }
    }
}
