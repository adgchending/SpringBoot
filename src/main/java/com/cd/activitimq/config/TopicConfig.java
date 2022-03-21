package com.cd.activitimq.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Topic;


@Configuration
@EnableJms//启动消息队列
public class TopicConfig {

    //自定义mq的id名称
    @Value("${mytopic}")
    private String QMname;


    //定义存放消息的队列
    @Bean
    public Topic topic() {
        return new ActiveMQTopic(QMname);
    }
}
