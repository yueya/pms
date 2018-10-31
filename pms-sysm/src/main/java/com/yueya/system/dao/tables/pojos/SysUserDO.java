/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import org.jooq.types.ULong;


/**
 * 用户表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysUserDO implements Serializable {

    private static final long serialVersionUID = -415066592;

    private ULong     id;
    private String    userCode;
    private String    organizationId;
    private String    departmentId;
    private String    loginName;
    private String    password;
    private String    userNo;
    private String    name;
    private String    email;
    private String    phone;
    private String    mobile;
    private String    userType;
    private String    photo;
    private String    loginIp;
    private Timestamp loginDate;
    private String    loginFlag;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String    remarks;
    private String    delFlag;

    public SysUserDO() {}

    public SysUserDO(SysUserDO value) {
        this.id = value.id;
        this.userCode = value.userCode;
        this.organizationId = value.organizationId;
        this.departmentId = value.departmentId;
        this.loginName = value.loginName;
        this.password = value.password;
        this.userNo = value.userNo;
        this.name = value.name;
        this.email = value.email;
        this.phone = value.phone;
        this.mobile = value.mobile;
        this.userType = value.userType;
        this.photo = value.photo;
        this.loginIp = value.loginIp;
        this.loginDate = value.loginDate;
        this.loginFlag = value.loginFlag;
        this.gmtCreate = value.gmtCreate;
        this.gmtModified = value.gmtModified;
        this.remarks = value.remarks;
        this.delFlag = value.delFlag;
    }

    public SysUserDO(
        ULong     id,
        String    userCode,
        String    organizationId,
        String    departmentId,
        String    loginName,
        String    password,
        String    userNo,
        String    name,
        String    email,
        String    phone,
        String    mobile,
        String    userType,
        String    photo,
        String    loginIp,
        Timestamp loginDate,
        String    loginFlag,
        Timestamp gmtCreate,
        Timestamp gmtModified,
        String    remarks,
        String    delFlag
    ) {
        this.id = id;
        this.userCode = userCode;
        this.organizationId = organizationId;
        this.departmentId = departmentId;
        this.loginName = loginName;
        this.password = password;
        this.userNo = userNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.userType = userType;
        this.photo = photo;
        this.loginIp = loginIp;
        this.loginDate = loginDate;
        this.loginFlag = loginFlag;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.remarks = remarks;
        this.delFlag = delFlag;
    }

    public ULong getId() {
        return this.id;
    }

    public void setId(ULong id) {
        this.id = id;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNo() {
        return this.userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLoginIp() {
        return this.loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Timestamp getLoginDate() {
        return this.loginDate;
    }

    public void setLoginDate(Timestamp loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginFlag() {
        return this.loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
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
        StringBuilder sb = new StringBuilder("SysUserDO (");

        sb.append(id);
        sb.append(", ").append(userCode);
        sb.append(", ").append(organizationId);
        sb.append(", ").append(departmentId);
        sb.append(", ").append(loginName);
        sb.append(", ").append(password);
        sb.append(", ").append(userNo);
        sb.append(", ").append(name);
        sb.append(", ").append(email);
        sb.append(", ").append(phone);
        sb.append(", ").append(mobile);
        sb.append(", ").append(userType);
        sb.append(", ").append(photo);
        sb.append(", ").append(loginIp);
        sb.append(", ").append(loginDate);
        sb.append(", ").append(loginFlag);
        sb.append(", ").append(gmtCreate);
        sb.append(", ").append(gmtModified);
        sb.append(", ").append(remarks);
        sb.append(", ").append(delFlag);

        sb.append(")");
        return sb.toString();
    }
}
