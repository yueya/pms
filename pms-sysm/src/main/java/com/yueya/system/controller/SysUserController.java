package com.yueya.system.controller;

import com.yueya.auth.realm.Principal;
import com.yueya.auth.utils.UserInfoUtil;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.model.UserInfo;
import com.yueya.system.dao.tables.SysMenu;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.service.SysMenuService;
import com.yueya.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("${adminPath}/user")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysMenuService menuService;
    @RequestMapping("info")
    public RestResult info(){
        Principal principal=UserInfoUtil.getPrincipal();
        UserInfo user=userService.info(principal.getId());
        return RestResult.OkWithData(user);
    }
    @RequestMapping("menus")
    public RestResult menus(){
        Principal principal=UserInfoUtil.getPrincipal();
        List<SysMenuDO> menus=menuService.list(principal.getId());
        return RestResult.OkWithData(menus);
    }

}
