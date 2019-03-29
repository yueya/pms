package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysOrganizationDO;
import com.yueya.system.service.SysOrgService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/org")
public class SysOrgsController extends BaseController {

    @Autowired
    private SysOrgService orgService;

    @RequiresPermissions("sys:org:insert")
    @PostMapping("insert")
    public RestResult insert(@RequestBody SysOrganizationDO orgDo){
        orgService.insert(orgDo);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:org:update")
    @RequestMapping("update")
    public RestResult update(@RequestBody SysOrganizationDO orgDo){
        orgService.update(orgDo);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:org:delete")
    @RequestMapping("delete")
    public RestResult delete(String ids){
        orgService.delete(ids);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:org:show")
    @RequestMapping("list")
    public RestResult list(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit, SysOrganizationDO orgDo){
        List<SysOrganizationDO> list=orgService.findAll();
        return RestResult.OkWithData(list);
    }

}
