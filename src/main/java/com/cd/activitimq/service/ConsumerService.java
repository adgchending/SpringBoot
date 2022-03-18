package com.cd.activitimq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @类名:ConsumerService
 * @类描述:消息消费者
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
public class ConsumerService {



    // 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "queue01")
//     SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
    @SendTo("SQueue")
    public String handleMessage(String name) {

        System.out.println("成功接受" + name);
        return "成功接受" + name;
    }

}
