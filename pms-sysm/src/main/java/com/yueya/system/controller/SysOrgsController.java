package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysOrganizationDO;
import com.yueya.system.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/org")
public class SysOrgsController extends BaseController {

    @Autowired
    private SysOrgService orgService;

    @PostMapping("insert")
    public RestResult insert(@RequestBody SysOrganizationDO orgDo){
        orgService.insert(orgDo);
        return RestResult.OK("success");
    }
    @RequestMapping("update")
    public RestResult update(@RequestBody SysOrganizationDO orgDo){
        orgService.update(orgDo);
        return RestResult.OK("success");
    }
    @RequestMapping("delete")
    public RestResult delete(String ids){
        orgService.delete(ids);
        return RestResult.OK("success");
    }
    @RequestMapping("list")
    public RestResult list(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit, SysOrganizationDO orgDo){
        List<SysOrganizationDO> list=orgService.findAll();
        return RestResult.OkWithData(list);
    }

}
