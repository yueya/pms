/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables;


import com.yueya.system.dao.Indexes;
import com.yueya.system.dao.Keys;
import com.yueya.system.dao.Pms;
import com.yueya.system.dao.tables.records.SysRolePermissionRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRolePermission extends TableImpl<SysRolePermissionRecord> {

    private static final long serialVersionUID = 1012313048;

    /**
     * The reference instance of <code>pms.sys_role_permission</code>
     */
    public static final SysRolePermission SYS_ROLE_PERMISSION = new SysRolePermission();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysRolePermissionRecord> getRecordType() {
        return SysRolePermissionRecord.class;
    }

    /**
     * The column <code>pms.sys_role_permission.role_id</code>. 角色id
     */
    public final TableField<SysRolePermissionRecord, Long> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "角色id");

    /**
     * The column <code>pms.sys_role_permission.permission_id</code>. 权限id
     */
    public final TableField<SysRolePermissionRecord, Long> PERMISSION_ID = createField("permission_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "权限id");

    /**
     * The column <code>pms.sys_role_permission.id</code>. id
     */
    public final TableField<SysRolePermissionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "id");

    /**
     * Create a <code>pms.sys_role_permission</code> table reference
     */
    public SysRolePermission() {
        this(DSL.name("sys_role_permission"), null);
    }

    /**
     * Create an aliased <code>pms.sys_role_permission</code> table reference
     */
    public SysRolePermission(String alias) {
        this(DSL.name(alias), SYS_ROLE_PERMISSION);
    }

    /**
     * Create an aliased <code>pms.sys_role_permission</code> table reference
     */
    public SysRolePermission(Name alias) {
        this(alias, SYS_ROLE_PERMISSION);
    }

    private SysRolePermission(Name alias, Table<SysRolePermissionRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysRolePermission(Name alias, Table<SysRolePermissionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SysRolePermission(Table<O> child, ForeignKey<O, SysRolePermissionRecord> key) {
        super(child, key, SYS_ROLE_PERMISSION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Pms.PMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYS_ROLE_PERMISSION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SysRolePermissionRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_ROLE_PERMISSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysRolePermissionRecord> getPrimaryKey() {
        return Keys.KEY_SYS_ROLE_PERMISSION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysRolePermissionRecord>> getKeys() {
        return Arrays.<UniqueKey<SysRolePermissionRecord>>asList(Keys.KEY_SYS_ROLE_PERMISSION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRolePermission as(String alias) {
        return new SysRolePermission(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRolePermission as(Name alias) {
        return new SysRolePermission(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRolePermission rename(String name) {
        return new SysRolePermission(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRolePermission rename(Name name) {
        return new SysRolePermission(name, null);
    }
}
