package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService menuService;

    @PostMapping("insert")
    public RestResult insert(SysMenuDO menuDO){
        menuService.insert(menuDO);
        return RestResult.OK("success");
    }
    @RequestMapping("update")
    public RestResult update(SysMenuDO menuDO){
        menuService.update(menuDO);
        return RestResult.OK("success");
    }
    @RequestMapping("delete")
    public RestResult delete(String ids){
        menuService.delete(ids);
        return RestResult.OK("success");
    }
    @RequestMapping("list")
    public RestResult list(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit, SysMenuDO menuDO){
        List<SysMenuDO> list=menuService.findAll();
        return RestResult.OkWithData(list);
    }

}
