package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysLogDao;
import com.yueya.system.dao.tables.pojos.SysLogDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogService extends BaseService {
    @Autowired
    private SysLogDao logDao;

    public void saveLog(SysLogDO log){
        logDao.insert(log);
    }
}
