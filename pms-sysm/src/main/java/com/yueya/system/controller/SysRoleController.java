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
        return RestResult.OK();
    }
    @PostMapping("update")
    public RestResult update(@RequestBody SysRoleDO roleDO){
        roleService.update(roleDO);
        return RestResult.OK();
    }
    @RequestMapping("delete")
    public RestResult delete(@RequestParam("ids") String ids){
        roleService.delete(ids);
        return RestResult.OK();
    }

    @RequestMapping("menu")
    public RestResult roleMenus(@RequestParam("id") String id) {
        return RestResult.OkWithData(roleService.roleMenus(id));
    }

    @PostMapping("auth")
    public RestResult auth(@RequestParam("roleId") String roleId,@RequestParam("menuIds") String menuIds) {
        roleService.authMenus(roleId,menuIds);
        return RestResult.OK();
    }

    /**
     * 已分配该角色的用户
     * @return
     */
    @RequestMapping("users")
    public RestResult users(@RequestParam("id") String id) {
        return RestResult.OkWithData(roleService.fetchUsers(id));
    }

    @PostMapping("assign")
    public RestResult assign(@RequestParam("addIds") String addIds,
                             @RequestParam("delIds") String delIds,
                             @RequestParam("roleId") String roleId) {
        roleService.assign(addIds.trim(),delIds.trim(),roleId);
        return RestResult.OK();
    }
}
