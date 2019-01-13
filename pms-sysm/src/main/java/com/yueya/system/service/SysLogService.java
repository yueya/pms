package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysLogDao;
import com.yueya.system.dao.tables.pojos.SysLogDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogService extends BaseService<SysLogDO> {
    @Autowired
    private SysLogDao logDao;

    public void saveLog(SysLogDO log){
        logDao.insert(log);
    }

    @Override
    public List<Condition> getConditions(SysLogDO logDO) {
        return null;
    }
}
