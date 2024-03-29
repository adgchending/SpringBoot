package com;

import com.cd.common.util.DateSourceUtil.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@Import(DynamicDataSourceRegister.class)//开启多数据源
@EnableTransactionManagement//开启事物
@ComponentScan({"org.activiti.rest.diagram", "com.cd"})//开启放行,不然访问会被activiti.rest拦截
@EnableScheduling//开启定时任务(让SpringBoot知道你在用定时器)
@MapperScan(basePackages = {"com.cd.*.dao"})//扫描该路径下的mapper
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class,
})
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

}
