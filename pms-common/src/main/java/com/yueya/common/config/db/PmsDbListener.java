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
    private static final ThreadLocal<Integer> holder = new ThreadLocal<>();
    /**
     * 数据源名称
     */
    private static final int DATASOURCE_WRITE = 0;
    private static final int DATASOURCE_READ = 1;

    @Override
    public void executeStart(ExecuteContext ctx) {
        logger.debug("执行类型："+ctx.type().toString());
        /**
         * 实际上主库数据同步到从库不一定是及时的，如果碰到id是自增长，且插入数据后立刻需要返回插入的id
         * 的情况，程序可能会读取到错误的数据，所以如果上次是写操作，那么下一次的读操作将立即从主库读取
         */
        //todo 待实际测试
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
        return holder.get() == null || DATASOURCE_READ == holder.get();
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
