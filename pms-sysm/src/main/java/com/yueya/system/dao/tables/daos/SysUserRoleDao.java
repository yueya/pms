/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.daos;


import com.yueya.common.base.BaseDao;
import com.yueya.system.dao.tables.pojos.SysUserRoleDO;
import com.yueya.system.dao.tables.records.SysUserRoleRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SysUserRoleDao extends BaseDao<SysUserRoleRecord, SysUserRoleDO, ULong> {

    /**
     * Create a new SysUserRoleDao without any configuration
     */
    public SysUserRoleDao() {
        super(com.yueya.system.dao.tables.SysUserRole.SYS_USER_ROLE, SysUserRoleDO.class);
    }

    /**
     * Create a new SysUserRoleDao with an attached configuration
     */
    @Autowired
    public SysUserRoleDao(Configuration configuration) {
        super(com.yueya.system.dao.tables.SysUserRole.SYS_USER_ROLE, SysUserRoleDO.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ULong getId(SysUserRoleDO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SysUserRoleDO> fetchById(ULong... values) {
        return fetch(com.yueya.system.dao.tables.SysUserRole.SYS_USER_ROLE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public SysUserRoleDO fetchOneById(ULong value) {
        return fetchOne(com.yueya.system.dao.tables.SysUserRole.SYS_USER_ROLE.ID, value);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<SysUserRoleDO> fetchByUserId(Integer... values) {
        return fetch(com.yueya.system.dao.tables.SysUserRole.SYS_USER_ROLE.USER_ID, values);
    }

    /**
     * Fetch records that have <code>role_id IN (values)</code>
     */
    public List<SysUserRoleDO> fetchByRoleId(Integer... values) {
        return fetch(com.yueya.system.dao.tables.SysUserRole.SYS_USER_ROLE.ROLE_ID, values);
    }
}
