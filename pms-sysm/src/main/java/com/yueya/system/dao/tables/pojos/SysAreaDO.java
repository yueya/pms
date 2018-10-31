/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 区域表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysAreaDO implements Serializable {

    private static final long serialVersionUID = 1788586400;

    private Long      id;
    private Long      parentId;
    private String    parentIds;
    private String    name;
    private Integer   sort;
    private String    code;
    private String    type;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String    remarks;
    private String    delFlag;

    public SysAreaDO() {}

    public SysAreaDO(SysAreaDO value) {
        this.id = value.id;
        this.parentId = value.parentId;
        this.parentIds = value.parentIds;
        this.name = value.name;
        this.sort = value.sort;
        this.code = value.code;
        this.type = value.type;
        this.gmtCreate = value.gmtCreate;
        this.gmtModified = value.gmtModified;
        this.remarks = value.remarks;
        this.delFlag = value.delFlag;
    }

    public SysAreaDO(
        Long      id,
        Long      parentId,
        String    parentIds,
        String    name,
        Integer   sort,
        String    code,
        String    type,
        Timestamp gmtCreate,
        Timestamp gmtModified,
        String    remarks,
        String    delFlag
    ) {
        this.id = id;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.name = name;
        this.sort = sort;
        this.code = code;
        this.type = type;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.remarks = remarks;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return this.parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysAreaDO (");

        sb.append(id);
        sb.append(", ").append(parentId);
        sb.append(", ").append(parentIds);
        sb.append(", ").append(name);
        sb.append(", ").append(sort);
        sb.append(", ").append(code);
        sb.append(", ").append(type);
        sb.append(", ").append(gmtCreate);
        sb.append(", ").append(gmtModified);
        sb.append(", ").append(remarks);
        sb.append(", ").append(delFlag);

        sb.append(")");
        return sb.toString();
    }
}
