package com.yueya.system.controller;

import com.yueya.auth.model.SessionPage;
import com.yueya.auth.session.SessionDao;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${auth.adminPath}/sessions")
public class SessionController extends BaseController {

    @Autowired
    private SessionDao sessionDao;
    //@RequiresPermissions("user:admin")
    @RequestMapping("/list")
    public RestResult listActiveSessions(@RequestParam(name = "limit",defaultValue = "10") int limit,
                                         @RequestParam(name = "offset",defaultValue = "0") int offset){
        SessionPage page=sessionDao.getActiveSessions(offset,limit);
        return RestResult.OkWithData(page);
    }
}
