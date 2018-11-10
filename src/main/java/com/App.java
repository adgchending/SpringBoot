package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事物
@EnableTransactionManagement
@ComponentScan
//开启定时任务(让SpringBoot知道你在用定时器)
@EnableScheduling
public class App{

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}
