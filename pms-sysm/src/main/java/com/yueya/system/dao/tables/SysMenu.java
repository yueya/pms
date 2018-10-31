/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables;


import com.yueya.system.dao.Indexes;
import com.yueya.system.dao.Keys;
import com.yueya.system.dao.Pms;
import com.yueya.system.dao.tables.records.SysMenuRecord;

import java.sql.Timestamp;
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
public class SysMenu extends TableImpl<SysMenuRecord> {

    private static final long serialVersionUID = 447645296;

    /**
     * The reference instance of <code>pms.sys_menu</code>
     */
    public static final SysMenu SYS_MENU = new SysMenu();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysMenuRecord> getRecordType() {
        return SysMenuRecord.class;
    }

    /**
     * The column <code>pms.sys_menu.id</code>. id
     */
    public final TableField<SysMenuRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "id");

    /**
     * The column <code>pms.sys_menu.name</code>. 菜单名称
     */
    public final TableField<SysMenuRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "菜单名称");

    /**
     * The column <code>pms.sys_menu.parent_id</code>.
     */
    public final TableField<SysMenuRecord, String> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>pms.sys_menu.parent_ids</code>.
     */
    public final TableField<SysMenuRecord, String> PARENT_IDS = createField("parent_ids", org.jooq.impl.SQLDataType.VARCHAR(1000), this, "");

    /**
     * The column <code>pms.sys_menu.type</code>. 菜单类型
     */
    public final TableField<SysMenuRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(255), this, "菜单类型");

    /**
     * The column <code>pms.sys_menu.tree_sort</code>. 本组排序
     */
    public final TableField<SysMenuRecord, Integer> TREE_SORT = createField("tree_sort", org.jooq.impl.SQLDataType.INTEGER, this, "本组排序");

    /**
     * The column <code>pms.sys_menu.system_code</code>. 所属系统标识
     */
    public final TableField<SysMenuRecord, String> SYSTEM_CODE = createField("system_code", org.jooq.impl.SQLDataType.VARCHAR(45), this, "所属系统标识");

    /**
     * The column <code>pms.sys_menu.all_sort</code>. 才所有菜单中的排序
     */
    public final TableField<SysMenuRecord, Integer> ALL_SORT = createField("all_sort", org.jooq.impl.SQLDataType.INTEGER, this, "才所有菜单中的排序");

    /**
     * The column <code>pms.sys_menu.href</code>. 链接
     */
    public final TableField<SysMenuRecord, String> HREF = createField("href", org.jooq.impl.SQLDataType.VARCHAR(1000), this, "链接");

    /**
     * The column <code>pms.sys_menu.target</code>. 目标
     */
    public final TableField<SysMenuRecord, String> TARGET = createField("target", org.jooq.impl.SQLDataType.VARCHAR(45), this, "目标");

    /**
     * The column <code>pms.sys_menu.icon</code>. 图标
     */
    public final TableField<SysMenuRecord, String> ICON = createField("icon", org.jooq.impl.SQLDataType.VARCHAR(255), this, "图标");

    /**
     * The column <code>pms.sys_menu.color</code>. 颜色
     */
    public final TableField<SysMenuRecord, String> COLOR = createField("color", org.jooq.impl.SQLDataType.VARCHAR(45), this, "颜色");

    /**
     * The column <code>pms.sys_menu.weight</code>. 权重
     */
    public final TableField<SysMenuRecord, Short> WEIGHT = createField("weight", org.jooq.impl.SQLDataType.SMALLINT, this, "权重");

    /**
     * The column <code>pms.sys_menu.useable</code>. 是否可用
     */
    public final TableField<SysMenuRecord, String> USEABLE = createField("useable", org.jooq.impl.SQLDataType.CHAR(1), this, "是否可用");

    /**
     * The column <code>pms.sys_menu.remarks</code>. 备注
     */
    public final TableField<SysMenuRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR(500), this, "备注");

    /**
     * The column <code>pms.sys_menu.gmt_create</code>. 创建时间
     */
    public final TableField<SysMenuRecord, Timestamp> GMT_CREATE = createField("gmt_create", org.jooq.impl.SQLDataType.TIMESTAMP, this, "创建时间");

    /**
     * The column <code>pms.sys_menu.gmt_modified</code>. 修改时间
     */
    public final TableField<SysMenuRecord, Timestamp> GMT_MODIFIED = createField("gmt_modified", org.jooq.impl.SQLDataType.TIMESTAMP, this, "修改时间");

    /**
     * The column <code>pms.sys_menu.del_flag</code>. 删除标记
     */
    public final TableField<SysMenuRecord, String> DEL_FLAG = createField("del_flag", org.jooq.impl.SQLDataType.CHAR(1), this, "删除标记");

    /**
     * Create a <code>pms.sys_menu</code> table reference
     */
    public SysMenu() {
        this(DSL.name("sys_menu"), null);
    }

    /**
     * Create an aliased <code>pms.sys_menu</code> table reference
     */
    public SysMenu(String alias) {
        this(DSL.name(alias), SYS_MENU);
    }

    /**
     * Create an aliased <code>pms.sys_menu</code> table reference
     */
    public SysMenu(Name alias) {
        this(alias, SYS_MENU);
    }

    private SysMenu(Name alias, Table<SysMenuRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysMenu(Name alias, Table<SysMenuRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SysMenu(Table<O> child, ForeignKey<O, SysMenuRecord> key) {
        super(child, key, SYS_MENU);
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
        return Arrays.<Index>asList(Indexes.SYS_MENU_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SysMenuRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_MENU;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysMenuRecord> getPrimaryKey() {
        return Keys.KEY_SYS_MENU_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysMenuRecord>> getKeys() {
        return Arrays.<UniqueKey<SysMenuRecord>>asList(Keys.KEY_SYS_MENU_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenu as(String alias) {
        return new SysMenu(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenu as(Name alias) {
        return new SysMenu(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysMenu rename(String name) {
        return new SysMenu(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysMenu rename(Name name) {
        return new SysMenu(name, null);
    }
}
