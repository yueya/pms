/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.records;


import com.yueya.system.dao.tables.SysLog;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 日志表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysLogRecord extends UpdatableRecordImpl<SysLogRecord> implements Record12<Long, String, String, String, String, Timestamp, String, String, String, String, String, String> {

    private static final long serialVersionUID = -934025402;

    /**
     * Setter for <code>pms.sys_log.id</code>. 编号
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>pms.sys_log.id</code>. 编号
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>pms.sys_log.app_id</code>. 系统id
     */
    public void setAppId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pms.sys_log.app_id</code>. 系统id
     */
    public String getAppId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pms.sys_log.type</code>. 日志类型
     */
    public void setType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pms.sys_log.type</code>. 日志类型
     */
    public String getType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pms.sys_log.title</code>. 日志标题
     */
    public void setTitle(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>pms.sys_log.title</code>. 日志标题
     */
    public String getTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>pms.sys_log.create_by</code>. 创建者
     */
    public void setCreateBy(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>pms.sys_log.create_by</code>. 创建者
     */
    public String getCreateBy() {
        return (String) get(4);
    }

    /**
     * Setter for <code>pms.sys_log.create_date</code>. 创建时间
     */
    public void setCreateDate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>pms.sys_log.create_date</code>. 创建时间
     */
    public Timestamp getCreateDate() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>pms.sys_log.remote_addr</code>. 操作IP地址
     */
    public void setRemoteAddr(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>pms.sys_log.remote_addr</code>. 操作IP地址
     */
    public String getRemoteAddr() {
        return (String) get(6);
    }

    /**
     * Setter for <code>pms.sys_log.user_agent</code>. 用户代理
     */
    public void setUserAgent(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>pms.sys_log.user_agent</code>. 用户代理
     */
    public String getUserAgent() {
        return (String) get(7);
    }

    /**
     * Setter for <code>pms.sys_log.request_uri</code>. 请求URI
     */
    public void setRequestUri(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>pms.sys_log.request_uri</code>. 请求URI
     */
    public String getRequestUri() {
        return (String) get(8);
    }

    /**
     * Setter for <code>pms.sys_log.method</code>. 操作方式
     */
    public void setMethod(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>pms.sys_log.method</code>. 操作方式
     */
    public String getMethod() {
        return (String) get(9);
    }

    /**
     * Setter for <code>pms.sys_log.params</code>. 操作提交的数据
     */
    public void setParams(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>pms.sys_log.params</code>. 操作提交的数据
     */
    public String getParams() {
        return (String) get(10);
    }

    /**
     * Setter for <code>pms.sys_log.exception</code>. 异常信息
     */
    public void setException(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>pms.sys_log.exception</code>. 异常信息
     */
    public String getException() {
        return (String) get(11);
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
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Long, String, String, String, String, Timestamp, String, String, String, String, String, String> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Long, String, String, String, String, Timestamp, String, String, String, String, String, String> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return SysLog.SYS_LOG.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysLog.SYS_LOG.APP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysLog.SYS_LOG.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SysLog.SYS_LOG.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysLog.SYS_LOG.CREATE_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return SysLog.SYS_LOG.CREATE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return SysLog.SYS_LOG.REMOTE_ADDR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return SysLog.SYS_LOG.USER_AGENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return SysLog.SYS_LOG.REQUEST_URI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return SysLog.SYS_LOG.METHOD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return SysLog.SYS_LOG.PARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return SysLog.SYS_LOG.EXCEPTION;
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
        return getAppId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCreateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getRemoteAddr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getUserAgent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getRequestUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getMethod();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getException();
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
        return getAppId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCreateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getRemoteAddr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getUserAgent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getRequestUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getMethod();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value2(String value) {
        setAppId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value3(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value4(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value5(String value) {
        setCreateBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value6(Timestamp value) {
        setCreateDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value7(String value) {
        setRemoteAddr(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value8(String value) {
        setUserAgent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value9(String value) {
        setRequestUri(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value10(String value) {
        setMethod(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value11(String value) {
        setParams(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord value12(String value) {
        setException(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysLogRecord values(Long value1, String value2, String value3, String value4, String value5, Timestamp value6, String value7, String value8, String value9, String value10, String value11, String value12) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysLogRecord
     */
    public SysLogRecord() {
        super(SysLog.SYS_LOG);
    }

    /**
     * Create a detached, initialised SysLogRecord
     */
    public SysLogRecord(Long id, String appId, String type, String title, String createBy, Timestamp createDate, String remoteAddr, String userAgent, String requestUri, String method, String params, String exception) {
        super(SysLog.SYS_LOG);

        set(0, id);
        set(1, appId);
        set(2, type);
        set(3, title);
        set(4, createBy);
        set(5, createDate);
        set(6, remoteAddr);
        set(7, userAgent);
        set(8, requestUri);
        set(9, method);
        set(10, params);
        set(11, exception);
    }
}
