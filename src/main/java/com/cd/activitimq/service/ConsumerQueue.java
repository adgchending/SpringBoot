package com.cd.activitimq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * @类名:ConsumerQueue
 * @类描述:消息消费者 Queue模式
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
public class ConsumerQueue {
    // 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "${myqueue}")
//     SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.广播模式
    @SendTo("SQueue")
    public void handleMessage(String name) throws JMSException {

        System.out.println("接收到消息:" + name);
    }

}
