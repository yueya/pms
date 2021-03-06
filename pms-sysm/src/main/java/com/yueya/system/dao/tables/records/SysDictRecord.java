/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.records;


import com.yueya.system.dao.tables.SysDict;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysDictRecord extends UpdatableRecordImpl<SysDictRecord> implements Record8<Long, String, String, Integer, String, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = -1176850535;

    /**
     * Setter for <code>pms.sys_dict.id</code>. id
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>pms.sys_dict.id</code>. id
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>pms.sys_dict.name</code>. 字典名称
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pms.sys_dict.name</code>. 字典名称
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pms.sys_dict.code</code>. 字典标识
     */
    public void setCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pms.sys_dict.code</code>. 字典标识
     */
    public String getCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pms.sys_dict.sort</code>. 排序字段
     */
    public void setSort(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>pms.sys_dict.sort</code>. 排序字段
     */
    public Integer getSort() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>pms.sys_dict.type</code>. 字典类型
     */
    public void setType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>pms.sys_dict.type</code>. 字典类型
     */
    public String getType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>pms.sys_dict.gmt_create</code>. 创建时间
     */
    public void setGmtCreate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>pms.sys_dict.gmt_create</code>. 创建时间
     */
    public Timestamp getGmtCreate() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>pms.sys_dict.gmt_modified</code>. 修改时间
     */
    public void setGmtModified(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>pms.sys_dict.gmt_modified</code>. 修改时间
     */
    public Timestamp getGmtModified() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>pms.sys_dict.del_flag</code>. 删除标记
     */
    public void setDelFlag(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>pms.sys_dict.del_flag</code>. 删除标记
     */
    public String getDelFlag() {
        return (String) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, String, Integer, String, Timestamp, Timestamp, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, String, Integer, String, Timestamp, Timestamp, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return SysDict.SYS_DICT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysDict.SYS_DICT.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysDict.SYS_DICT.CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return SysDict.SYS_DICT.SORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysDict.SYS_DICT.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return SysDict.SYS_DICT.GMT_CREATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return SysDict.SYS_DICT.GMT_MODIFIED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return SysDict.SYS_DICT.DEL_FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getGmtCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component7() {
        return getGmtModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getDelFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getGmtCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getGmtModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getDelFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value3(String value) {
        setCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value4(Integer value) {
        setSort(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value5(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value6(Timestamp value) {
        setGmtCreate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value7(Timestamp value) {
        setGmtModified(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value8(String value) {
        setDelFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord values(Long value1, String value2, String value3, Integer value4, String value5, Timestamp value6, Timestamp value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysDictRecord
     */
    public SysDictRecord() {
        super(SysDict.SYS_DICT);
    }

    /**
     * Create a detached, initialised SysDictRecord
     */
    public SysDictRecord(Long id, String name, String code, Integer sort, String type, Timestamp gmtCreate, Timestamp gmtModified, String delFlag) {
        super(SysDict.SYS_DICT);

        set(0, id);
        set(1, name);
        set(2, code);
        set(3, sort);
        set(4, type);
        set(5, gmtCreate);
        set(6, gmtModified);
        set(7, delFlag);
    }
}
