/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.records;


import com.yueya.system.dao.tables.SysMenu;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysMenuRecord extends UpdatableRecordImpl<SysMenuRecord> implements Record18<Long, String, String, String, String, Integer, String, Integer, String, String, String, String, Short, String, String, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = 2070596603;

    /**
     * Setter for <code>pms.sys_menu.id</code>. id
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>pms.sys_menu.id</code>. id
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>pms.sys_menu.name</code>. 菜单名称
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pms.sys_menu.name</code>. 菜单名称
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pms.sys_menu.parent_id</code>.
     */
    public void setParentId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pms.sys_menu.parent_id</code>.
     */
    public String getParentId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pms.sys_menu.parent_ids</code>.
     */
    public void setParentIds(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>pms.sys_menu.parent_ids</code>.
     */
    public String getParentIds() {
        return (String) get(3);
    }

    /**
     * Setter for <code>pms.sys_menu.type</code>. 菜单类型
     */
    public void setType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>pms.sys_menu.type</code>. 菜单类型
     */
    public String getType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>pms.sys_menu.tree_sort</code>. 本组排序
     */
    public void setTreeSort(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>pms.sys_menu.tree_sort</code>. 本组排序
     */
    public Integer getTreeSort() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>pms.sys_menu.system_code</code>. 所属系统标识
     */
    public void setSystemCode(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>pms.sys_menu.system_code</code>. 所属系统标识
     */
    public String getSystemCode() {
        return (String) get(6);
    }

    /**
     * Setter for <code>pms.sys_menu.all_sort</code>. 才所有菜单中的排序
     */
    public void setAllSort(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>pms.sys_menu.all_sort</code>. 才所有菜单中的排序
     */
    public Integer getAllSort() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>pms.sys_menu.href</code>. 链接
     */
    public void setHref(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>pms.sys_menu.href</code>. 链接
     */
    public String getHref() {
        return (String) get(8);
    }

    /**
     * Setter for <code>pms.sys_menu.target</code>. 目标
     */
    public void setTarget(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>pms.sys_menu.target</code>. 目标
     */
    public String getTarget() {
        return (String) get(9);
    }

    /**
     * Setter for <code>pms.sys_menu.icon</code>. 图标
     */
    public void setIcon(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>pms.sys_menu.icon</code>. 图标
     */
    public String getIcon() {
        return (String) get(10);
    }

    /**
     * Setter for <code>pms.sys_menu.color</code>. 颜色
     */
    public void setColor(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>pms.sys_menu.color</code>. 颜色
     */
    public String getColor() {
        return (String) get(11);
    }

    /**
     * Setter for <code>pms.sys_menu.weight</code>. 权重
     */
    public void setWeight(Short value) {
        set(12, value);
    }

    /**
     * Getter for <code>pms.sys_menu.weight</code>. 权重
     */
    public Short getWeight() {
        return (Short) get(12);
    }

    /**
     * Setter for <code>pms.sys_menu.useable</code>. 是否可用
     */
    public void setUseable(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>pms.sys_menu.useable</code>. 是否可用
     */
    public String getUseable() {
        return (String) get(13);
    }

    /**
     * Setter for <code>pms.sys_menu.remarks</code>. 备注
     */
    public void setRemarks(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>pms.sys_menu.remarks</code>. 备注
     */
    public String getRemarks() {
        return (String) get(14);
    }

    /**
     * Setter for <code>pms.sys_menu.gmt_create</code>. 创建时间
     */
    public void setGmtCreate(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>pms.sys_menu.gmt_create</code>. 创建时间
     */
    public Timestamp getGmtCreate() {
        return (Timestamp) get(15);
    }

    /**
     * Setter for <code>pms.sys_menu.gmt_modified</code>. 修改时间
     */
    public void setGmtModified(Timestamp value) {
        set(16, value);
    }

    /**
     * Getter for <code>pms.sys_menu.gmt_modified</code>. 修改时间
     */
    public Timestamp getGmtModified() {
        return (Timestamp) get(16);
    }

    /**
     * Setter for <code>pms.sys_menu.del_flag</code>. 删除标记
     */
    public void setDelFlag(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>pms.sys_menu.del_flag</code>. 删除标记
     */
    public String getDelFlag() {
        return (String) get(17);
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
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, String, String, String, String, Integer, String, Integer, String, String, String, String, Short, String, String, Timestamp, Timestamp, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, String, String, String, String, Integer, String, Integer, String, String, String, String, Short, String, String, Timestamp, Timestamp, String> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return SysMenu.SYS_MENU.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysMenu.SYS_MENU.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysMenu.SYS_MENU.PARENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SysMenu.SYS_MENU.PARENT_IDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysMenu.SYS_MENU.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return SysMenu.SYS_MENU.TREE_SORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return SysMenu.SYS_MENU.SYSTEM_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return SysMenu.SYS_MENU.ALL_SORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return SysMenu.SYS_MENU.HREF;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return SysMenu.SYS_MENU.TARGET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return SysMenu.SYS_MENU.ICON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return SysMenu.SYS_MENU.COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Short> field13() {
        return SysMenu.SYS_MENU.WEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return SysMenu.SYS_MENU.USEABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return SysMenu.SYS_MENU.REMARKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field16() {
        return SysMenu.SYS_MENU.GMT_CREATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field17() {
        return SysMenu.SYS_MENU.GMT_MODIFIED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field18() {
        return SysMenu.SYS_MENU.DEL_FLAG;
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
        return getParentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getParentIds();
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
    public Integer component6() {
        return getTreeSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getSystemCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getAllSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getHref();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getTarget();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getIcon();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getColor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short component13() {
        return getWeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getUseable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component16() {
        return getGmtCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component17() {
        return getGmtModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component18() {
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
        return getParentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getParentIds();
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
    public Integer value6() {
        return getTreeSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getSystemCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getAllSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getHref();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getTarget();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getIcon();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getColor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Short value13() {
        return getWeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getUseable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value16() {
        return getGmtCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value17() {
        return getGmtModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value18() {
        return getDelFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value3(String value) {
        setParentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value4(String value) {
        setParentIds(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value5(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value6(Integer value) {
        setTreeSort(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value7(String value) {
        setSystemCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value8(Integer value) {
        setAllSort(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value9(String value) {
        setHref(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value10(String value) {
        setTarget(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value11(String value) {
        setIcon(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value12(String value) {
        setColor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value13(Short value) {
        setWeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value14(String value) {
        setUseable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value15(String value) {
        setRemarks(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value16(Timestamp value) {
        setGmtCreate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value17(Timestamp value) {
        setGmtModified(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord value18(String value) {
        setDelFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysMenuRecord values(Long value1, String value2, String value3, String value4, String value5, Integer value6, String value7, Integer value8, String value9, String value10, String value11, String value12, Short value13, String value14, String value15, Timestamp value16, Timestamp value17, String value18) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysMenuRecord
     */
    public SysMenuRecord() {
        super(SysMenu.SYS_MENU);
    }

    /**
     * Create a detached, initialised SysMenuRecord
     */
    public SysMenuRecord(Long id, String name, String parentId, String parentIds, String type, Integer treeSort, String systemCode, Integer allSort, String href, String target, String icon, String color, Short weight, String useable, String remarks, Timestamp gmtCreate, Timestamp gmtModified, String delFlag) {
        super(SysMenu.SYS_MENU);

        set(0, id);
        set(1, name);
        set(2, parentId);
        set(3, parentIds);
        set(4, type);
        set(5, treeSort);
        set(6, systemCode);
        set(7, allSort);
        set(8, href);
        set(9, target);
        set(10, icon);
        set(11, color);
        set(12, weight);
        set(13, useable);
        set(14, remarks);
        set(15, gmtCreate);
        set(16, gmtModified);
        set(17, delFlag);
    }
}
