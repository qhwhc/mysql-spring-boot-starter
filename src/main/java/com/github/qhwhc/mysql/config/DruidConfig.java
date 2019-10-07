package com.github.qhwhc.mysql.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.qhwhc.mysql.constant.DataSourceName;
import com.github.qhwhc.mysql.datasource.DynamicDataSource;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AutoConfigureBefore(DruidDataSourceAutoConfigure.class)
public class DruidConfig {
    @Primary
    @Bean(name = {"dynamicDataSource"})
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(DataSourceName.MASTER, masterDataSource);
        targetDataSources.put(DataSourceName.SLAVE, slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }
    @ConfigurationProperties("spring.datasource.druid.master")
    @Bean
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @ConditionalOnProperty(havingValue = "true", name = {"open"}, prefix = "spring.datasource.druid.slave")
    @ConfigurationProperties("spring.datasource.druid.slave")
    @Bean
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
