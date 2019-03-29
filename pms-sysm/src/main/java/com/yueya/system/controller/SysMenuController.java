package com.yueya.system.controller;

import com.yueya.auth.utils.UserInfoUtil;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.service.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService menuService;

    @RequiresPermissions("sys:menu:insert")
    @PostMapping("insert")
    public RestResult insert(@RequestBody SysMenuDO menuDO){
        menuService.insert(menuDO);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:menu:update")
    @RequestMapping("update")
    public RestResult update(@RequestBody SysMenuDO menuDO){
        menuService.update(menuDO);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:menu:delete")
    @RequestMapping("delete")
    public RestResult delete(String ids){
        menuService.delete(ids);
        return RestResult.OK("success");
    }
    @RequestMapping("user")
    public RestResult userList() {
        String userId = UserInfoUtil.getPrincipal().getId();
        return RestResult.OkWithData(menuService.list(userId));
    }
    @RequiresPermissions("sys:menu:show")
    @RequestMapping("list")
    public RestResult list(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit, SysMenuDO menuDO){
        List<SysMenuDO> list=menuService.findAll();
        return RestResult.OkWithData(list);
    }

}
