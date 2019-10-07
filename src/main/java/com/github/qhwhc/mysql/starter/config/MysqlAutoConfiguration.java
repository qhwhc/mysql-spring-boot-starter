package com.github.qhwhc.mysql.starter.config;

import com.github.qhwhc.mysql.starter.properties.MysqlProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MysqlProperties.class)
public class MysqlAutoConfiguration {

}
