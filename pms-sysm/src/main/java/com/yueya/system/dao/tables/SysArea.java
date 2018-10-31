/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables;


import com.yueya.system.dao.Indexes;
import com.yueya.system.dao.Jeesite;
import com.yueya.system.dao.Keys;
import com.yueya.system.dao.tables.records.SysAreaRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
 * 区域表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysArea extends TableImpl<SysAreaRecord> {

    private static final long serialVersionUID = -1634053262;

    /**
     * The reference instance of <code>jeesite.sys_area</code>
     */
    public static final SysArea SYS_AREA = new SysArea();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysAreaRecord> getRecordType() {
        return SysAreaRecord.class;
    }

    /**
     * The column <code>jeesite.sys_area.id</code>. 编号
     */
    public final TableField<SysAreaRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "编号");

    /**
     * The column <code>jeesite.sys_area.parent_id</code>. 父级编号
     */
    public final TableField<SysAreaRecord, String> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "父级编号");

    /**
     * The column <code>jeesite.sys_area.parent_ids</code>. 所有父级编号
     */
    public final TableField<SysAreaRecord, String> PARENT_IDS = createField("parent_ids", org.jooq.impl.SQLDataType.VARCHAR(2000).nullable(false), this, "所有父级编号");

    /**
     * The column <code>jeesite.sys_area.name</code>. 名称
     */
    public final TableField<SysAreaRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "名称");

    /**
     * The column <code>jeesite.sys_area.sort</code>. 排序
     */
    public final TableField<SysAreaRecord, Long> SORT = createField("sort", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "排序");

    /**
     * The column <code>jeesite.sys_area.code</code>. 区域编码
     */
    public final TableField<SysAreaRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "区域编码");

    /**
     * The column <code>jeesite.sys_area.type</code>. 区域类型
     */
    public final TableField<SysAreaRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.CHAR(1), this, "区域类型");

    /**
     * The column <code>jeesite.sys_area.create_by</code>. 创建者
     */
    public final TableField<SysAreaRecord, String> CREATE_BY = createField("create_by", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "创建者");

    /**
     * The column <code>jeesite.sys_area.create_date</code>. 创建时间
     */
    public final TableField<SysAreaRecord, Timestamp> CREATE_DATE = createField("create_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * The column <code>jeesite.sys_area.update_by</code>. 更新者
     */
    public final TableField<SysAreaRecord, String> UPDATE_BY = createField("update_by", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "更新者");

    /**
     * The column <code>jeesite.sys_area.update_date</code>. 更新时间
     */
    public final TableField<SysAreaRecord, Timestamp> UPDATE_DATE = createField("update_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "更新时间");

    /**
     * The column <code>jeesite.sys_area.remarks</code>. 备注信息
     */
    public final TableField<SysAreaRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR(255), this, "备注信息");

    /**
     * The column <code>jeesite.sys_area.del_flag</code>. 删除标记
     */
    public final TableField<SysAreaRecord, String> DEL_FLAG = createField("del_flag", org.jooq.impl.SQLDataType.CHAR(1).nullable(false).defaultValue(DSL.inline("0", org.jooq.impl.SQLDataType.CHAR)), this, "删除标记");

    /**
     * Create a <code>jeesite.sys_area</code> table reference
     */
    public SysArea() {
        this(DSL.name("sys_area"), null);
    }

    /**
     * Create an aliased <code>jeesite.sys_area</code> table reference
     */
    public SysArea(String alias) {
        this(DSL.name(alias), SYS_AREA);
    }

    /**
     * Create an aliased <code>jeesite.sys_area</code> table reference
     */
    public SysArea(Name alias) {
        this(alias, SYS_AREA);
    }

    private SysArea(Name alias, Table<SysAreaRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysArea(Name alias, Table<SysAreaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("区域表"));
    }

    public <O extends Record> SysArea(Table<O> child, ForeignKey<O, SysAreaRecord> key) {
        super(child, key, SYS_AREA);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Jeesite.JEESITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYS_AREA_PRIMARY, Indexes.SYS_AREA_SYS_AREA_DEL_FLAG, Indexes.SYS_AREA_SYS_AREA_PARENT_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysAreaRecord> getPrimaryKey() {
        return Keys.KEY_SYS_AREA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysAreaRecord>> getKeys() {
        return Arrays.<UniqueKey<SysAreaRecord>>asList(Keys.KEY_SYS_AREA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysArea as(String alias) {
        return new SysArea(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysArea as(Name alias) {
        return new SysArea(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysArea rename(String name) {
        return new SysArea(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysArea rename(Name name) {
        return new SysArea(name, null);
    }
}
