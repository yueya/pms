/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.daos;


import com.yueya.common.base.BaseDao;
import com.yueya.system.dao.tables.pojos.SysSystemDO;
import com.yueya.system.dao.tables.records.SysSystemRecord;

import java.sql.Timestamp;
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
public class SysSystemDao extends BaseDao<SysSystemRecord, SysSystemDO, ULong> {

    /**
     * Create a new SysSystemDao without any configuration
     */
    public SysSystemDao() {
        super(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM, SysSystemDO.class);
    }

    /**
     * Create a new SysSystemDao with an attached configuration
     */
    @Autowired
    public SysSystemDao(Configuration configuration) {
        super(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM, SysSystemDO.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ULong getId(SysSystemDO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SysSystemDO> fetchById(ULong... values) {
        return fetch(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public SysSystemDO fetchOneById(ULong value) {
        return fetchOne(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<SysSystemDO> fetchByName(String... values) {
        return fetch(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.NAME, values);
    }

    /**
     * Fetch records that have <code>useable IN (values)</code>
     */
    public List<SysSystemDO> fetchByUseable(String... values) {
        return fetch(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.USEABLE, values);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<SysSystemDO> fetchByCode(String... values) {
        return fetch(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.CODE, values);
    }

    /**
     * Fetch records that have <code>gmt_create IN (values)</code>
     */
    public List<SysSystemDO> fetchByGmtCreate(Timestamp... values) {
        return fetch(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.GMT_CREATE, values);
    }

    /**
     * Fetch records that have <code>gmt_modified IN (values)</code>
     */
    public List<SysSystemDO> fetchByGmtModified(Timestamp... values) {
        return fetch(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.GMT_MODIFIED, values);
    }

    /**
     * Fetch records that have <code>def_flag IN (values)</code>
     */
    public List<SysSystemDO> fetchByDefFlag(String... values) {
        return fetch(com.yueya.system.dao.tables.SysSystem.SYS_SYSTEM.DEF_FLAG, values);
    }
}
