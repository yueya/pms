package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysSystemDO;
import com.yueya.system.service.SysSystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/system")
public class SysSystemController extends BaseController {

    @Autowired
    private SysSystemService systemService;

    @RequiresPermissions("sys:system:show")
    @RequestMapping("list")
    public RestResult list(){
        return RestResult.OkWithData(systemService.findAll());
    }

    @RequiresPermissions("sys:system:insert")
    @PostMapping("insert")
    public RestResult insert(@RequestBody SysSystemDO systemDO){
        systemService.insert(systemDO);
        return RestResult.OK("success");
    }

    @RequiresPermissions("sys:system:update")
    @PostMapping("update")
    public RestResult update(@RequestBody SysSystemDO systemDO){
        systemService.update(systemDO);
        return RestResult.OK("success");
    }

    @RequiresPermissions("sys:system:delete")
    @RequestMapping("delete")
    public RestResult delete(String ids){
        systemService.delete(ids);
        return RestResult.OK("success");
    }

    @RequiresPermissions("sys:system:show")
    @RequestMapping("page")
    public RestResult list(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit, SysSystemDO systemDO){
        List<SysSystemDO> list=systemService.page(systemDO,offset,limit);
        long count = systemService.countByCondition(systemDO);

        return RestResult.OKWithPage(list, count);
    }
}
