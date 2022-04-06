//package com.cd.activitimq.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.jms.Queue;
//import javax.jms.Topic;
//import java.util.UUID;
//
///**
// * @类名:ProductionTopic
// * @类描述:消息队列,需要启动F:\RJ\activemq\apache-activemq-5.15.3\bin\win64下的activemq.bat(消息队列服务器)
// * 消息队列服务器:http://localhost:8161/admin/queues.jsp
// *
// * 消息生产者
// *
// * @创建日期: 2022/2/25
// * @修改记录:
// * <pre>
// *    修改日期：
// *    版 本 号：
// *    修 改 人：
// *    修改内容：
// * </pre>
// * @author: csx
// */
//@RestController
//@Api(tags = "ActiveMq-消息队列-Topic模式")
//@RequestMapping("/ActiveTopic")
//@Component
//public class ProductionTopic {
//
//    //注入存放消息的队列，用于下列方法一
//    @Autowired
//    private Topic topic;
//
//    //注入springboot封装的工具类
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//
////    @ApiOperation(value = "新增消息放入mq服务器")
////    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
////    public void send(@RequestParam String maggage) {
////        //方法一：添加消息到消息队列
////        jmsMessagingTemplate.convertAndSend(topic, maggage);
////        System.out.println(maggage);
////    }
//
//
//    @ApiOperation(value = "每间隔3秒 定时发送消息到消息服务器")
//    @PostMapping(value = "/sendDs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
////    @Scheduled(cron = "${wtxprops.cron}")
//    @Scheduled(fixedDelay = 6000)//每隔3秒执行一次,启动项目后会定时发送
//    public void sendds() {
//        //方法一：添加消息到消息队列
//        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
//        jmsMessagingTemplate.convertAndSend(topic, "topic消息"+uuid);
//    }
//
//}
//
