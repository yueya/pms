/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 日志表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysLogDO implements Serializable {

    private static final long serialVersionUID = -651197566;

    private Long      id;
    private String    appId;
    private String    type;
    private String    title;
    private String    createBy;
    private Timestamp createDate;
    private String    remoteAddr;
    private String    userAgent;
    private String    requestUri;
    private String    method;
    private String    params;
    private String    exception;

    public SysLogDO() {}

    public SysLogDO(SysLogDO value) {
        this.id = value.id;
        this.appId = value.appId;
        this.type = value.type;
        this.title = value.title;
        this.createBy = value.createBy;
        this.createDate = value.createDate;
        this.remoteAddr = value.remoteAddr;
        this.userAgent = value.userAgent;
        this.requestUri = value.requestUri;
        this.method = value.method;
        this.params = value.params;
        this.exception = value.exception;
    }

    public SysLogDO(
        Long      id,
        String    appId,
        String    type,
        String    title,
        String    createBy,
        Timestamp createDate,
        String    remoteAddr,
        String    userAgent,
        String    requestUri,
        String    method,
        String    params,
        String    exception
    ) {
        this.id = id;
        this.appId = appId;
        this.type = type;
        this.title = title;
        this.createBy = createBy;
        this.createDate = createDate;
        this.remoteAddr = remoteAddr;
        this.userAgent = userAgent;
        this.requestUri = requestUri;
        this.method = method;
        this.params = params;
        this.exception = exception;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getRemoteAddr() {
        return this.remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRequestUri() {
        return this.requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getException() {
        return this.exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysLogDO (");

        sb.append(id);
        sb.append(", ").append(appId);
        sb.append(", ").append(type);
        sb.append(", ").append(title);
        sb.append(", ").append(createBy);
        sb.append(", ").append(createDate);
        sb.append(", ").append(remoteAddr);
        sb.append(", ").append(userAgent);
        sb.append(", ").append(requestUri);
        sb.append(", ").append(method);
        sb.append(", ").append(params);
        sb.append(", ").append(exception);

        sb.append(")");
        return sb.toString();
    }
}
