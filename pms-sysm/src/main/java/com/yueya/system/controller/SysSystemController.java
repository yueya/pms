package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.daos.SysSystemDao;
import com.yueya.system.service.SysSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${auth.adminPath}/system")
public class SysSystemController extends BaseController {

    @Autowired
    private SysSystemService systemService;

    @RequestMapping("list")
    public RestResult list(){
        return RestResult.OkWithData(systemService.findAll());
    }
}
