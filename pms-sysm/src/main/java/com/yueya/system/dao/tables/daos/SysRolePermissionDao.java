/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.daos;


import com.yueya.common.base.BaseDao;
import com.yueya.system.dao.tables.pojos.SysRolePermissionDO;
import com.yueya.system.dao.tables.records.SysRolePermissionRecord;

import java.util.List;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SysRolePermissionDao extends BaseDao<SysRolePermissionRecord, SysRolePermissionDO, Long> {

    /**
     * Create a new SysRolePermissionDao without any configuration
     */
    public SysRolePermissionDao() {
        super(com.yueya.system.dao.tables.SysRolePermission.SYS_ROLE_PERMISSION, SysRolePermissionDO.class);
    }

    /**
     * Create a new SysRolePermissionDao with an attached configuration
     */
    @Autowired
    public SysRolePermissionDao(Configuration configuration) {
        super(com.yueya.system.dao.tables.SysRolePermission.SYS_ROLE_PERMISSION, SysRolePermissionDO.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(SysRolePermissionDO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>role_id IN (values)</code>
     */
    public List<SysRolePermissionDO> fetchByRoleId(Long... values) {
        return fetch(com.yueya.system.dao.tables.SysRolePermission.SYS_ROLE_PERMISSION.ROLE_ID, values);
    }

    /**
     * Fetch records that have <code>permission_id IN (values)</code>
     */
    public List<SysRolePermissionDO> fetchByPermissionId(Long... values) {
        return fetch(com.yueya.system.dao.tables.SysRolePermission.SYS_ROLE_PERMISSION.PERMISSION_ID, values);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SysRolePermissionDO> fetchById(Long... values) {
        return fetch(com.yueya.system.dao.tables.SysRolePermission.SYS_ROLE_PERMISSION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public SysRolePermissionDO fetchOneById(Long value) {
        return fetchOne(com.yueya.system.dao.tables.SysRolePermission.SYS_ROLE_PERMISSION.ID, value);
    }
}
