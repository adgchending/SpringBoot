package com.cd.activitimq.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;


@Configuration
@EnableJms//启动消息队列
public class QueueConfig {

    //自定义mq的id名称
    @Value("${myqueue}")
    private String QMname;


    //定义存放消息的队列
    @Bean
    public Queue queue() {
        return new ActiveMQQueue(QMname);
    }
}
