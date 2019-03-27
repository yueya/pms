package com.yueya.system.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import com.yueya.system.dao.dto.ViewDto;
import com.yueya.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("${auth.adminPath}/stastis")
@RestController
public class StastisController extends BaseController {

    @Autowired
    private SysLogService logService;
    @RequestMapping("index")
    public RestResult index() {
        Map<String, Object> map = new HashMap<>();
        List<ViewDto> list1 = logService.queryCountBySystem();
        List<ViewDto> list2 = logService.queryCountByHref();
        map.put("sys", list1);
        map.put("href", list2);
        return RestResult.OkWithData(map);
    }
}
