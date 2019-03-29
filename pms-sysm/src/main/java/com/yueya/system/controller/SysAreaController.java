package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysAreaDO;
import com.yueya.system.service.SysAreaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/area")
public class SysAreaController extends BaseController {

    @Autowired
    private SysAreaService areaService;


    @RequiresPermissions("sys:area:insert")
    @PostMapping("insert")
    public RestResult insert(@RequestBody SysAreaDO areaDO){
        areaService.insert(areaDO);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:area:update")
    @RequestMapping("update")
    public RestResult update(@RequestBody SysAreaDO areaDO){
        areaService.update(areaDO);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:area:delete")
    @RequestMapping("delete")
    public RestResult delete(String ids){
        areaService.delete(ids);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:area:show")
    @RequestMapping("list")
    public RestResult list(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit, SysAreaDO areaDO){
        List<SysAreaDO> list=areaService.findAll();
        return RestResult.OkWithData(list);
    }
}
