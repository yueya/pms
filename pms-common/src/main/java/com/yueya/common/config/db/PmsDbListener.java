package com.yueya.common.config.db;

import org.jooq.ExecuteContext;
import org.jooq.ExecuteType;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultExecuteListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Component;

@Component
public class PmsDbListener extends DefaultExecuteListener {
    private Logger logger=LoggerFactory.getLogger(getClass());
    @Autowired
    private DataSourceConnectionProvider connectionProviderMaster;
    @Autowired
    private DataSourceConnectionProvider connectionProviderSlave;
    private static final ThreadLocal<String> holder = new ThreadLocal<>();
    /**
     * 数据源名称
     */
    private static final String DATASOURCE_WRITE = "write";
    private static final String DATASOURCE_READ = "read";

    @Override
    public void executeStart(ExecuteContext ctx) {
        logger.info("执行类型："+ctx.type().toString());
        if(ctx.type().equals(ExecuteType.READ)  && lastIsRead()){
            logger.debug("use slave db");
            ctx.connectionProvider(connectionProviderSlave);
            markRead();
        }else{
            logger.debug("use master db");
            ctx.connectionProvider(connectionProviderMaster);
            markWrite();
        }
    }

    public void markWrite() {
        holder.set(DATASOURCE_WRITE);
    }
    public void markRead(){
        holder.set(DATASOURCE_READ);
    }
    public static boolean lastIsRead() {
        return holder.get()==null||DATASOURCE_READ.equals(holder.get());
    }
    @Override
    public void exception(ExecuteContext context) {
        SQLDialect dialect = context.configuration().dialect();
        SQLExceptionTranslator translator
                = new SQLErrorCodeSQLExceptionTranslator(dialect.name());
        context.exception(translator
                .translate("Access database using jOOQ", context.sql(), context.sqlException()));
    }
}
