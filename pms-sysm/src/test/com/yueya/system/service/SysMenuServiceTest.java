package com.yueya.system.service;

import com.yueya.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SysMenuServiceTest extends BaseTest {
    @Autowired
    SysMenuService menuService;

    @Test
    public void testDelete(){
        menuService.delete("2");
    }

}
