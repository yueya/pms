/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables;


import com.yueya.system.dao.Indexes;
import com.yueya.system.dao.Keys;
import com.yueya.system.dao.Pms;
import com.yueya.system.dao.tables.records.SysRoleMenuRecord;

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
public class SysRoleMenu extends TableImpl<SysRoleMenuRecord> {

    private static final long serialVersionUID = 649044656;

    /**
     * The reference instance of <code>pms.sys_role_menu</code>
     */
    public static final SysRoleMenu SYS_ROLE_MENU = new SysRoleMenu();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysRoleMenuRecord> getRecordType() {
        return SysRoleMenuRecord.class;
    }

    /**
     * The column <code>pms.sys_role_menu.id</code>.
     */
    public final TableField<SysRoleMenuRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>pms.sys_role_menu.menu_id</code>. 菜单id
     */
    public final TableField<SysRoleMenuRecord, Integer> MENU_ID = createField("menu_id", org.jooq.impl.SQLDataType.INTEGER, this, "菜单id");

    /**
     * The column <code>pms.sys_role_menu.role_id</code>. 角色id
     */
    public final TableField<SysRoleMenuRecord, Integer> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.INTEGER, this, "角色id");

    /**
     * Create a <code>pms.sys_role_menu</code> table reference
     */
    public SysRoleMenu() {
        this(DSL.name("sys_role_menu"), null);
    }

    /**
     * Create an aliased <code>pms.sys_role_menu</code> table reference
     */
    public SysRoleMenu(String alias) {
        this(DSL.name(alias), SYS_ROLE_MENU);
    }

    /**
     * Create an aliased <code>pms.sys_role_menu</code> table reference
     */
    public SysRoleMenu(Name alias) {
        this(alias, SYS_ROLE_MENU);
    }

    private SysRoleMenu(Name alias, Table<SysRoleMenuRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysRoleMenu(Name alias, Table<SysRoleMenuRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SysRoleMenu(Table<O> child, ForeignKey<O, SysRoleMenuRecord> key) {
        super(child, key, SYS_ROLE_MENU);
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
        return Arrays.<Index>asList(Indexes.SYS_ROLE_MENU_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SysRoleMenuRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_ROLE_MENU;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysRoleMenuRecord> getPrimaryKey() {
        return Keys.KEY_SYS_ROLE_MENU_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysRoleMenuRecord>> getKeys() {
        return Arrays.<UniqueKey<SysRoleMenuRecord>>asList(Keys.KEY_SYS_ROLE_MENU_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleMenu as(String alias) {
        return new SysRoleMenu(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleMenu as(Name alias) {
        return new SysRoleMenu(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRoleMenu rename(String name) {
        return new SysRoleMenu(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRoleMenu rename(Name name) {
        return new SysRoleMenu(name, null);
    }
}
