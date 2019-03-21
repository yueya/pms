package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import com.yueya.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/role")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService roleService;

    @RequestMapping("page")
    public RestResult page(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit,
                           SysRoleDO roleDO){
        List<SysRoleDO> list = roleService.page(offset,limit,roleDO);
        long count = roleService.countByCondition(roleDO);
        return RestResult.OKWithPage(list,count);
    }

    @PostMapping("insert")
    public RestResult insert(@RequestBody SysRoleDO roleDO){
        roleService.insert(roleDO);
        return RestResult.OK("success");
    }
    @PostMapping("update")
    public RestResult update(@RequestBody SysRoleDO roleDO){
        roleService.update(roleDO);
        return RestResult.OK("success");
    }
    @RequestMapping("delete")
    public RestResult delete(String ids){
        roleService.delete(ids);
        return RestResult.OK("success");
    }
}
