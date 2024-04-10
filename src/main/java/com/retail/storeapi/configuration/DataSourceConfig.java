package com.retail.storeapi.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://database-dev.ceybct06hrhg.us-east-1.rds.amazonaws.com/health")
                .username("admin")
                .password("Intel$2112")
                .build();
    }
}
