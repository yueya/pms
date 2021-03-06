package com.yueya.system.controller;

import com.yueya.auth.realm.Principal;
import com.yueya.auth.utils.UserInfoUtil;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.dto.UserInfo;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import com.yueya.system.service.SysMenuService;
import com.yueya.system.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("${auth.adminPath}/user")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysMenuService menuService;

    @RequestMapping("profile")
    public RestResult profile(){
        Principal principal=UserInfoUtil.getPrincipal();
        UserInfo user=userService.info(principal.getUserName());
        return RestResult.OkWithData(user);
    }
    @RequestMapping("menus")
    public RestResult menus(){
        Principal principal=UserInfoUtil.getPrincipal();
        List<SysMenuDO> menus=menuService.list(principal.getId());
        return RestResult.OkWithData(menus);
    }

    @RequiresPermissions("sys:user:show")
    @RequestMapping("page")
    public RestResult page(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit,
                           SysUserDO userDO){
        List<SysUserDO> list = userService.page(offset,limit,userDO);
        long count = userService.countByCondition(userDO);
        return RestResult.OKWithPage(list,count);
    }

    @RequiresPermissions("sys:user:insert")
    @PostMapping("insert")
    public RestResult insert(@RequestBody @Validated SysUserDO userDO){
        SysUserDO old = userService.findByUserName(userDO.getLoginName());
        if (old!=null) {
           return RestResult.FAILER("该登录名已存在");
        }
        userService.insert(userDO);
        return RestResult.OK("success");
    }

    @RequiresPermissions("sys:user:update")
    @PostMapping("update")
    public RestResult update(@RequestBody SysUserDO userDO){
         userService.update(userDO);
         return RestResult.OK("success");
    }

    @RequiresPermissions("sys:user:delete")
    @RequestMapping("delete")
    public RestResult delete(String ids){
        userService.delete(ids);
        return RestResult.OK("success");
    }

}
