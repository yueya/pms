package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.common.util.DateUtils;
import com.yueya.system.dao.tables.SysRole;
import com.yueya.system.dao.tables.daos.SysRoleDao;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SysRoleService extends BaseService<SysRoleDO> {
    @Autowired
    private SysRoleDao dao;

    @Override
    public List<Condition> getConditions(SysRoleDO sysRoleDO) {
        Condition condition = SysRole.SYS_ROLE.DEL_FLAG.eq(DEL_FLAG_NORMAL);
        return Collections.singletonList(condition);
    }

    public void insert(SysRoleDO sysRoleDO) {
        sysRoleDO.setDelFlag(DEL_FLAG_NORMAL);
        sysRoleDO.setGmtCreate(DateUtils.getCurTimeStamp());
        dao.insert(sysRoleDO);
    }

    public void update(SysRoleDO sysRoleDO) {
        sysRoleDO.setGmtModified(DateUtils.getCurTimeStamp());
        dao.update(sysRoleDO);
    }

    public void delete(String id) {
        SysRoleDO sysRoleDO = new SysRoleDO();
        sysRoleDO.setDelFlag(DEL_FLAG_DEL);
        sysRoleDO.setId(Long.valueOf(id));
        dao.update(sysRoleDO);
    }


    public List<SysRoleDO> page(int offset, int limit, SysRoleDO roleDO) {
        return dao.page(offset, limit, getConditions(roleDO));
    }

    public long countByCondition(SysRoleDO roleDO) {
        return dao.countByCondition(getConditions(roleDO));
    }
}
