package com.yueya.system.dao.tables.daos;

import com.yueya.BaseTest;
import com.yueya.system.dao.tables.SysRole;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;


public class SysRoleDaoTest extends BaseTest{

    @Autowired
    SysRoleDao dao;
    @Test
    public void fetchByUserId() {
        List<SysRoleDO> list=dao.fetchByUserId(Long.valueOf("1"));
       assertNotNull(list);
       dao.page(0,1, Collections.emptyList(),SysRole.SYS_ROLE.GMT_CREATE.desc())
       .forEach( r -> System.out.println(r.getGmtCreate().toString()));
    }
}