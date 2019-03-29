package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestPage;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysLogDO;
import com.yueya.system.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("${auth.adminPath}/log")
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService logService;
    @RequiresPermissions("sys:log:show")
    @RequestMapping("page")
    public RestResult page(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit,
                           SysLogDO logDO){
        List<SysLogDO> list = logService.page(offset,limit,logDO);
        long count = logService.countByCondition(logDO);
        return RestResult.OKWithPage(list,count);
    }
}
