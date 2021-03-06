/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysMenuDO implements Serializable {

    private static final long serialVersionUID = 1830334553;

    private Long      id;
    private String    name;
    private String    parentId;
    private String    parentIds;
    private String    type;
    private Integer   sort;
    private String    systemCode;
    private String    href;
    private String    target;
    private String    icon;
    private String    color;
    private Short     weight;
    private String    useable;
    private String    remarks;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String    delFlag;
    private String    permission;

    public SysMenuDO() {}

    public SysMenuDO(SysMenuDO value) {
        this.id = value.id;
        this.name = value.name;
        this.parentId = value.parentId;
        this.parentIds = value.parentIds;
        this.type = value.type;
        this.sort = value.sort;
        this.systemCode = value.systemCode;
        this.href = value.href;
        this.target = value.target;
        this.icon = value.icon;
        this.color = value.color;
        this.weight = value.weight;
        this.useable = value.useable;
        this.remarks = value.remarks;
        this.gmtCreate = value.gmtCreate;
        this.gmtModified = value.gmtModified;
        this.delFlag = value.delFlag;
        this.permission = value.permission;
    }

    public SysMenuDO(
        Long      id,
        String    name,
        String    parentId,
        String    parentIds,
        String    type,
        Integer   sort,
        String    systemCode,
        String    href,
        String    target,
        String    icon,
        String    color,
        Short     weight,
        String    useable,
        String    remarks,
        Timestamp gmtCreate,
        Timestamp gmtModified,
        String    delFlag,
        String    permission
    ) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.type = type;
        this.sort = sort;
        this.systemCode = systemCode;
        this.href = href;
        this.target = target;
        this.icon = icon;
        this.color = color;
        this.weight = weight;
        this.useable = useable;
        this.remarks = remarks;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.delFlag = delFlag;
        this.permission = permission;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return this.parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSystemCode() {
        return this.systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Short getWeight() {
        return this.weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    public String getUseable() {
        return this.useable;
    }

    public void setUseable(String useable) {
        this.useable = useable;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return this.gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysMenuDO (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(parentId);
        sb.append(", ").append(parentIds);
        sb.append(", ").append(type);
        sb.append(", ").append(sort);
        sb.append(", ").append(systemCode);
        sb.append(", ").append(href);
        sb.append(", ").append(target);
        sb.append(", ").append(icon);
        sb.append(", ").append(color);
        sb.append(", ").append(weight);
        sb.append(", ").append(useable);
        sb.append(", ").append(remarks);
        sb.append(", ").append(gmtCreate);
        sb.append(", ").append(gmtModified);
        sb.append(", ").append(delFlag);
        sb.append(", ").append(permission);

        sb.append(")");
        return sb.toString();
    }
}
