/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.records;


import com.yueya.system.dao.tables.SysRolePermission;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRolePermissionRecord extends UpdatableRecordImpl<SysRolePermissionRecord> implements Record3<Integer, Integer, Long> {

    private static final long serialVersionUID = 1161424405;

    /**
     * Setter for <code>pms.sys_role_permission.role_id</code>. 角色id
     */
    public void setRoleId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>pms.sys_role_permission.role_id</code>. 角色id
     */
    public Integer getRoleId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>pms.sys_role_permission.permission_id</code>. 权限id
     */
    public void setPermissionId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>pms.sys_role_permission.permission_id</code>. 权限id
     */
    public Integer getPermissionId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>pms.sys_role_permission.id</code>. id
     */
    public void setId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>pms.sys_role_permission.id</code>. id
     */
    public Long getId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return SysRolePermission.SYS_ROLE_PERMISSION.ROLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return SysRolePermission.SYS_ROLE_PERMISSION.PERMISSION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return SysRolePermission.SYS_ROLE_PERMISSION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getPermissionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getPermissionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRolePermissionRecord value1(Integer value) {
        setRoleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRolePermissionRecord value2(Integer value) {
        setPermissionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRolePermissionRecord value3(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRolePermissionRecord values(Integer value1, Integer value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysRolePermissionRecord
     */
    public SysRolePermissionRecord() {
        super(SysRolePermission.SYS_ROLE_PERMISSION);
    }

    /**
     * Create a detached, initialised SysRolePermissionRecord
     */
    public SysRolePermissionRecord(Integer roleId, Integer permissionId, Long id) {
        super(SysRolePermission.SYS_ROLE_PERMISSION);

        set(0, roleId);
        set(1, permissionId);
        set(2, id);
    }
}
