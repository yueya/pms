package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestPage;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.tables.pojos.SysDictDO;
import com.yueya.system.service.SysDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${auth.adminPath}/dict")
public class SysDictController extends BaseController {
    @Autowired
    private SysDictService dictService;

    @RequiresPermissions("sys:dict:insert")
    @PostMapping("insert")
    public RestResult insert(SysDictDO dictDO){
        dictService.insert(dictDO);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:dict:delete")
    @RequestMapping("delete")
    public RestResult delete(String ids){
        dictService.delete(ids);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:dict:update")
    @PostMapping("update")
    public RestResult update(SysDictDO dictDO){
        dictService.update(dictDO);
        return RestResult.OK("success");
    }
    @RequiresPermissions("sys:dict:show")
    @RequestMapping("page")
    public RestResult page(@RequestParam(defaultValue = "0") int offset,
                           @RequestParam(defaultValue = "10") int limit, SysDictDO dictDO){
        List<SysDictDO> list=dictService.page(offset,limit,dictDO);
        long count=dictService.count(dictDO);
        return RestResult.OkWithData(new RestPage(list,count));
    }
}
