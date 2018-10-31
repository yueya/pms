/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables;


import com.yueya.system.dao.Indexes;
import com.yueya.system.dao.Keys;
import com.yueya.system.dao.Pms;
import com.yueya.system.dao.tables.records.SysUserRoleRecord;

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
public class SysUserRole extends TableImpl<SysUserRoleRecord> {

    private static final long serialVersionUID = -403877512;

    /**
     * The reference instance of <code>pms.sys_user_role</code>
     */
    public static final SysUserRole SYS_USER_ROLE = new SysUserRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysUserRoleRecord> getRecordType() {
        return SysUserRoleRecord.class;
    }

    /**
     * The column <code>pms.sys_user_role.id</code>.
     */
    public final TableField<SysUserRoleRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>pms.sys_user_role.user_id</code>. 用户id
     */
    public final TableField<SysUserRoleRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER, this, "用户id");

    /**
     * The column <code>pms.sys_user_role.role_id</code>. 角色id
     */
    public final TableField<SysUserRoleRecord, Integer> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.INTEGER, this, "角色id");

    /**
     * Create a <code>pms.sys_user_role</code> table reference
     */
    public SysUserRole() {
        this(DSL.name("sys_user_role"), null);
    }

    /**
     * Create an aliased <code>pms.sys_user_role</code> table reference
     */
    public SysUserRole(String alias) {
        this(DSL.name(alias), SYS_USER_ROLE);
    }

    /**
     * Create an aliased <code>pms.sys_user_role</code> table reference
     */
    public SysUserRole(Name alias) {
        this(alias, SYS_USER_ROLE);
    }

    private SysUserRole(Name alias, Table<SysUserRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysUserRole(Name alias, Table<SysUserRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SysUserRole(Table<O> child, ForeignKey<O, SysUserRoleRecord> key) {
        super(child, key, SYS_USER_ROLE);
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
        return Arrays.<Index>asList(Indexes.SYS_USER_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SysUserRoleRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_USER_ROLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysUserRoleRecord> getPrimaryKey() {
        return Keys.KEY_SYS_USER_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysUserRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<SysUserRoleRecord>>asList(Keys.KEY_SYS_USER_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRole as(String alias) {
        return new SysUserRole(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRole as(Name alias) {
        return new SysUserRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysUserRole rename(String name) {
        return new SysUserRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysUserRole rename(Name name) {
        return new SysUserRole(name, null);
    }
}
