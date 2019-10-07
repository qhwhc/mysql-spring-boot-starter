package com.github.qhwhc.mysql.datasource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal();

    public static void setDB(String dbType) {
        log.info("切换到{}数据源", dbType);
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDB() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDB() {
        CONTEXT_HOLDER.remove();
    }
}
