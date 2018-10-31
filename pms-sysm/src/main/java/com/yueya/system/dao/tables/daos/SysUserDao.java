/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.daos;


import com.yueya.common.base.BaseDao;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import com.yueya.system.dao.tables.records.SysUserRecord;

import java.sql.Timestamp;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 用户表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SysUserDao extends BaseDao<SysUserRecord, SysUserDO, ULong> {

    /**
     * Create a new SysUserDao without any configuration
     */
    public SysUserDao() {
        super(com.yueya.system.dao.tables.SysUser.SYS_USER, SysUserDO.class);
    }

    /**
     * Create a new SysUserDao with an attached configuration
     */
    @Autowired
    public SysUserDao(Configuration configuration) {
        super(com.yueya.system.dao.tables.SysUser.SYS_USER, SysUserDO.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ULong getId(SysUserDO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SysUserDO> fetchById(ULong... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public SysUserDO fetchOneById(ULong value) {
        return fetchOne(com.yueya.system.dao.tables.SysUser.SYS_USER.ID, value);
    }

    /**
     * Fetch records that have <code>user_code IN (values)</code>
     */
    public List<SysUserDO> fetchByUserCode(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.USER_CODE, values);
    }

    /**
     * Fetch records that have <code>organization_id IN (values)</code>
     */
    public List<SysUserDO> fetchByOrganizationId(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.ORGANIZATION_ID, values);
    }

    /**
     * Fetch records that have <code>department_id IN (values)</code>
     */
    public List<SysUserDO> fetchByDepartmentId(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.DEPARTMENT_ID, values);
    }

    /**
     * Fetch records that have <code>login_name IN (values)</code>
     */
    public List<SysUserDO> fetchByLoginName(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.LOGIN_NAME, values);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<SysUserDO> fetchByPassword(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>user_no IN (values)</code>
     */
    public List<SysUserDO> fetchByUserNo(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.USER_NO, values);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<SysUserDO> fetchByName(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.NAME, values);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<SysUserDO> fetchByEmail(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.EMAIL, values);
    }

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    public List<SysUserDO> fetchByPhone(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.PHONE, values);
    }

    /**
     * Fetch records that have <code>mobile IN (values)</code>
     */
    public List<SysUserDO> fetchByMobile(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.MOBILE, values);
    }

    /**
     * Fetch records that have <code>user_type IN (values)</code>
     */
    public List<SysUserDO> fetchByUserType(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.USER_TYPE, values);
    }

    /**
     * Fetch records that have <code>photo IN (values)</code>
     */
    public List<SysUserDO> fetchByPhoto(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.PHOTO, values);
    }

    /**
     * Fetch records that have <code>login_ip IN (values)</code>
     */
    public List<SysUserDO> fetchByLoginIp(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.LOGIN_IP, values);
    }

    /**
     * Fetch records that have <code>login_date IN (values)</code>
     */
    public List<SysUserDO> fetchByLoginDate(Timestamp... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.LOGIN_DATE, values);
    }

    /**
     * Fetch records that have <code>login_flag IN (values)</code>
     */
    public List<SysUserDO> fetchByLoginFlag(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.LOGIN_FLAG, values);
    }

    /**
     * Fetch records that have <code>gmt_create IN (values)</code>
     */
    public List<SysUserDO> fetchByGmtCreate(Timestamp... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.GMT_CREATE, values);
    }

    /**
     * Fetch records that have <code>gmt_modified IN (values)</code>
     */
    public List<SysUserDO> fetchByGmtModified(Timestamp... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.GMT_MODIFIED, values);
    }

    /**
     * Fetch records that have <code>remarks IN (values)</code>
     */
    public List<SysUserDO> fetchByRemarks(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.REMARKS, values);
    }

    /**
     * Fetch records that have <code>del_flag IN (values)</code>
     */
    public List<SysUserDO> fetchByDelFlag(String... values) {
        return fetch(com.yueya.system.dao.tables.SysUser.SYS_USER.DEL_FLAG, values);
    }
}
