package com.yueya.system.dao.tables.daos;

import com.yueya.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SysLogDaoTest extends BaseTest {
   @Autowired
   SysLogDao logDao;
    @Test
    public void queryViewsBySystem() {
        logDao.queryViewsByHref().stream().forEach(r -> System.out.println(r.name));
    }
}
