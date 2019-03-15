package com.yueya.system.controller;

import com.yueya.auth.realm.Principal;
import com.yueya.auth.utils.CredentialsHelper;
import com.yueya.auth.utils.UserInfoUtil;
import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestPage;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.model.UserInfo;
import com.yueya.system.dao.tables.SysMenu;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import com.yueya.system.service.SysMenuService;
import com.yueya.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("${auth.adminPath}/user")
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
    @RequestMapping("page")
    public RestResult page(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit,
                           SysUserDO userDO){
        List<SysUserDO> list = userService.page(offset,limit,userDO);
        long count = userService.countByCondition(userDO);
        return RestResult.OKWithPage(list,count);
    }

    @PostMapping("insert")
    public RestResult insert(@RequestBody SysUserDO userDO){
        if(userDO.getPassword() != null){
            //密码加密
            userDO.setPassword(CredentialsHelper.entryptCredentials(userDO.getPassword()));
        }
        //设置一个用户的唯一标识码，暂时没什么用
        userDO.setUserCode(UUID.randomUUID().toString().replace("-",""));
        userService.insert(userDO);
        return RestResult.OK("success");
    }
    @PostMapping("update")
    public RestResult update(@RequestBody SysUserDO userDO){
        userService.update(userDO);
        return RestResult.OK("success");
    }
    @RequestMapping("delete")
    public RestResult delete(String ids){
        userService.delete(ids);
        return RestResult.OK("success");
    }

}
