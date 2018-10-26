package com.yueya.common.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public class MasterDbConfig {
    @Bean
    @ConfigurationProperties(prefix = "db.master")
    @Primary
    public DataSource dataSourceMaster() {
        return new DruidDataSource();
    }
    @Bean
    @Primary
    public DataSourceTransactionManager transactionManagerA() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSourceMaster());
        return transactionManager;
    }
}
