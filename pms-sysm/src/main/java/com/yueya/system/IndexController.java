package com.yueya.system;

import com.yueya.common.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/a")
public class IndexController extends BaseController {
    @RequestMapping("/index")
    public String index(){
        return new Date().toString();
    }
}
