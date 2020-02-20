package com.cd.common.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    /**
     * 项目编码
     */
    public static String projectCode;

    /**
     * 数据库配置url
     */
    public static String url;

    /**
     * 数据库用户名
     */
    public static String username;

    /**
     * 数据库密码
     */
    public static String password;

    /**
     * 数据库驱动
     */
    public static String driverClass;

    @Autowired
    public void setProjectCode(@Value("${csx.project_code}") String projectCode) {
        WebConfig.projectCode = projectCode;
    }

    @Autowired
    public void setUrl(@Value("${spring.datasource.url}") String url) {
        WebConfig.url = url;
    }

    @Autowired
    public void setUsername(@Value("${spring.datasource.username}") String username) {
        WebConfig.username = username;
    }

    @Autowired
    public void setPassword(@Value("${spring.datasource.password}") String password) {
        WebConfig.password = password;
    }

    @Autowired
    public void setDriverClass(@Value("${spring.datasource.driverClassName}") String driverClass) {
        WebConfig.driverClass = driverClass;
    }
}
