package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.SysLog;
import com.yueya.system.dao.tables.daos.SysLogDao;
import com.yueya.system.dao.tables.pojos.SysLogDO;
import com.yueya.system.dao.dto.ViewDto;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        return Collections.emptyList();
    }

    public List<SysLogDO> page(int offset, int limit ,SysLogDO logDO) {
        return logDao.page(offset,limit,getConditions(logDO), SysLog.SYS_LOG.CREATE_DATE.desc());
    }

    public long countByCondition(SysLogDO logDO) {
        return logDao.countByCondition(getConditions(logDO));
    }

    public List<ViewDto> queryCountBySystem() {
        return logDao.queryViewsBySystem();
    }

    public List<ViewDto> queryCountByHref() {
        return logDao.queryViewsByHref();
    }
}
