package com.yueya.cms;

import com.yueya.auth.config.AuthConfig;
import com.yueya.common.config.datasource.DataSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.yueya"},exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@Import(AuthConfig.class)
@EnableCaching
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
