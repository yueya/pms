package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysRoleDao;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleService extends BaseService<SysRoleDO> {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<Condition> getConditions(SysRoleDO sysRoleDO) {
        return null;
    }
}
