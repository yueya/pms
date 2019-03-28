package com.yueya.common.config.db;

import com.yueya.common.config.datasource.DataSourceConfiguration;
import org.jooq.SQLDialect;
import org.jooq.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ConditionalOnProperty(
        prefix = "spring.datasource.druid.one",
        name = "url"
)
@AutoConfigureAfter(DataSourceConfiguration.class)
public class JooqConfiguration {
    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;
    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource slaveDataSource;
    public DataSourceConnectionProvider connectionProviderMaster() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(masterDataSource));
    }
    public DataSourceConnectionProvider connectionProviderSlave() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(slaveDataSource));
    }
    @Bean
    public DefaultDSLContext dsl() {
        return new DefaultDSLContext(configuration());
    }
    @Bean
    public org.jooq.Configuration configuration() {

        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProviderMaster());
        PmsDbListener dbListener = new PmsDbListener();
        dbListener.setConnectionProviderMaster(connectionProviderMaster());
        dbListener.setConnectionProviderSlave(connectionProviderSlave());
        jooqConfiguration.set(new DefaultExecuteListenerProvider(dbListener));
        jooqConfiguration.setSQLDialect(SQLDialect.MYSQL);
        return jooqConfiguration;
    }


}
