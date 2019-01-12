package com.yueya.system.service;

import com.yueya.BaseTest;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SysUserServiceTest extends BaseTest {

    @Autowired
    SysUserService userService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUpdate(){
        SysUserDO user=new SysUserDO();
        user.setEmail("asddddddddd");
        user.setId(12L);
        userService.update(user);
    }
}