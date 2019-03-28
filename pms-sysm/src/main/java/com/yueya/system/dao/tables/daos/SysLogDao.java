/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao.tables.daos;


import com.yueya.auth.model.PmsLog;
import com.yueya.common.base.BaseDao;
import com.yueya.system.dao.tables.SysLog;
import com.yueya.system.dao.tables.SysSystem;
import com.yueya.system.dao.tables.pojos.SysLogDO;
import com.yueya.system.dao.tables.records.SysLogRecord;

import java.sql.Timestamp;
import java.util.List;

import com.yueya.system.dao.dto.ViewDto;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.meta.derby.sys.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 日志表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SysLogDao extends BaseDao<SysLogRecord, SysLogDO, Long> {

    /**
     * Create a new SysLogDao without any configuration
     */
    public SysLogDao() {
        super(com.yueya.system.dao.tables.SysLog.SYS_LOG, SysLogDO.class);
    }

    /**
     * Create a new SysLogDao with an attached configuration
     */
    @Autowired
    public SysLogDao(Configuration configuration) {
        super(com.yueya.system.dao.tables.SysLog.SYS_LOG, SysLogDO.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(SysLogDO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SysLogDO> fetchById(Long... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public SysLogDO fetchOneById(Long value) {
        return fetchOne(com.yueya.system.dao.tables.SysLog.SYS_LOG.ID, value);
    }

    /**
     * Fetch records that have <code>app_id IN (values)</code>
     */
    public List<SysLogDO> fetchByAppId(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.APP_ID, values);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<SysLogDO> fetchByType(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.TYPE, values);
    }

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    public List<SysLogDO> fetchByTitle(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.TITLE, values);
    }

    /**
     * Fetch records that have <code>create_by IN (values)</code>
     */
    public List<SysLogDO> fetchByCreateBy(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.CREATE_BY, values);
    }

    /**
     * Fetch records that have <code>create_date IN (values)</code>
     */
    public List<SysLogDO> fetchByCreateDate(Timestamp... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.CREATE_DATE, values);
    }

    /**
     * Fetch records that have <code>remote_addr IN (values)</code>
     */
    public List<SysLogDO> fetchByRemoteAddr(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.REMOTE_ADDR, values);
    }

    /**
     * Fetch records that have <code>user_agent IN (values)</code>
     */
    public List<SysLogDO> fetchByUserAgent(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.USER_AGENT, values);
    }

    /**
     * Fetch records that have <code>request_uri IN (values)</code>
     */
    public List<SysLogDO> fetchByRequestUri(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.REQUEST_URI, values);
    }

    /**
     * Fetch records that have <code>method IN (values)</code>
     */
    public List<SysLogDO> fetchByMethod(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.METHOD, values);
    }

    /**
     * Fetch records that have <code>params IN (values)</code>
     */
    public List<SysLogDO> fetchByParams(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.PARAMS, values);
    }

    /**
     * Fetch records that have <code>exception IN (values)</code>
     */
    public List<SysLogDO> fetchByException(String... values) {
        return fetch(com.yueya.system.dao.tables.SysLog.SYS_LOG.EXCEPTION, values);
    }

    public List<ViewDto> queryViewsBySystem() {
        DSLContext create=DSL.using(super.configuration());
        return create.select(SysSystem.SYS_SYSTEM.NAME.as("name"),DSL.count(SysSystem.SYS_SYSTEM.NAME).as("count"))
                .from(SysLog.SYS_LOG)
                .join(SysSystem.SYS_SYSTEM)
                .on(SysLog.SYS_LOG.APP_ID.eq(SysSystem.SYS_SYSTEM.CODE))
                .where(SysSystem.SYS_SYSTEM.DEF_FLAG.eq(DEL_NORMAL))
                .groupBy(SysSystem.SYS_SYSTEM.NAME).fetchInto(ViewDto.class);
    }

    public List<ViewDto> queryViewsByHref() {
        DSLContext create=DSL.using(super.configuration());
        return create.select(SysLog.SYS_LOG.REQUEST_URI.as("name"),DSL.count(SysLog.SYS_LOG.REQUEST_URI).as("count"))
                .from(SysLog.SYS_LOG)
                .where(SysLog.SYS_LOG.TYPE.eq(PmsLog.TYPE_ACCESS))
                .groupBy(SysLog.SYS_LOG.REQUEST_URI)
                .fetchInto(ViewDto.class);
    }
}
