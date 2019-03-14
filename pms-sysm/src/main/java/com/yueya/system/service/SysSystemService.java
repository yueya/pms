package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.common.util.DateUtils;
import com.yueya.system.dao.tables.SysSystem;
import com.yueya.system.dao.tables.daos.SysSystemDao;
import com.yueya.system.dao.tables.pojos.SysSystemDO;
import org.apache.commons.collections.ListUtils;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SysSystemService extends BaseService<SysSystemDO> {
    @Autowired
    private SysSystemDao dao;

    public void insert(SysSystemDO systemDO){
        systemDO.setDefFlag(DEL_FLAG_NORMAL);
        systemDO.setGmtCreate(DateUtils.getCurTimeStamp());
        dao.insert(systemDO);
    }

    public void update(SysSystemDO systemDO){
        systemDO.setGmtModified(DateUtils.getCurTimeStamp());
        dao.update(systemDO);
    }

    public void delete(String ids){
        List<Long> list= Arrays.stream(ids.split(","))
                .map(r->Long.valueOf(r)).collect(Collectors.toList());
        Condition condition = SysSystem.SYS_SYSTEM.ID.in(list);
        SysSystemDO systemDo = new SysSystemDO();
        systemDo.setDefFlag(DEL_FLAG_DEL);
        systemDo.setGmtModified(DateUtils.getCurTimeStamp());
        dao.updateByCondition(systemDo,condition);
    }

    public List<SysSystemDO> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Condition> getConditions(SysSystemDO sysSystemDO) {
        Condition condition = SysSystem.SYS_SYSTEM.DEF_FLAG.eq(DEL_FLAG_NORMAL);
        return Collections.singletonList(condition);
    }


    public List<SysSystemDO> page(SysSystemDO systemDO, int offset, int limit) {
            return dao.page(offset,limit,getConditions(systemDO));
    }

    public long countByCondition(SysSystemDO systemDO) {
        return dao.countByCondition(getConditions(systemDO));
    }
}
