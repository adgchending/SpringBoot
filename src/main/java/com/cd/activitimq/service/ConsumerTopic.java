package com.cd.activitimq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * @类名:ConsumerTopic
 * @类描述:消息消费者 topic模式
 * @创建日期: 2022/3/1
 * @修改记录: <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: csx
 */
@Component
public class ConsumerTopic {
    @JmsListener(destination = "${mytopic}")
    public void  receive(String name) throws JMSException {
        try{
            System.out.println("成功接受" + name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
