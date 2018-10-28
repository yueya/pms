package com.yueya.common.config.db;

import com.yueya.common.config.datasource.DataSourceConfiguration;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter(DataSourceConfiguration.class)
public class JooqConfiguration {
    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;
    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource slaveDataSource;
    @Autowired
    private PmsDbListener dbListener;
    @Bean
    public DataSourceConnectionProvider connectionProviderMaster() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(masterDataSource));
    }
    @Bean
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
        jooqConfiguration.set(new DefaultExecuteListenerProvider(dbListener));
        jooqConfiguration.setSQLDialect(SQLDialect.MYSQL);
        return jooqConfiguration;
    }


}
