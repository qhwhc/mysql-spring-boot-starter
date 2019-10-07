package com.github.qhwhc.mysql.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "qhwhc.tool")
public class MysqlProperties {
    private String enable = "true";
}
