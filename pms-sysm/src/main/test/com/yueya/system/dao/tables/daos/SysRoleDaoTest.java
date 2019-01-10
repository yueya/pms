package com.yueya.system.dao.tables.daos;

import com.yueya.BaseTest;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import java.util.List;


public class SysRoleDaoTest extends BaseTest{

    @Autowired
    SysRoleDao dao;
    @Test
    public void fetchByUserId() {
        List<SysRoleDO> list=dao.fetchByUserId("1");
       assertNotNull(list);
    }
}