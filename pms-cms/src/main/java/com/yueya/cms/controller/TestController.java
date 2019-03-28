package com.yueya.cms.controller;

import com.yueya.common.base.BaseController;
import com.yueya.common.web.RestResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${auth.adminPath}/test")
public class TestController extends BaseController {

    @RequestMapping("index")
    public RestResult index() {
        return RestResult.OkWithData("测试");
    }
}
