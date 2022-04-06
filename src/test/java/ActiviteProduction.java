import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @类名:ActiviteProduction
 * @类描述:Active生产消息
 * @创建日期: 2022/3/14
 * @修改记录: <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: csx
 */
public class ActiviteProduction {

    public static final String URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "csx_01";


    //消息发布到消息服务器
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //第一个参数   false/true 这个代表事务(偏向服务端)   第二个参数代表签收(偏向消费端)
        // AUTO_ACKNOWLEDGE = 1; 客户端发送和接受消息不需要额外工作,不需要ack(签收);
        // CLIENT_ACKNOWLEDGE = 2; 客户端确认,客户端接受消息,调用javax.jmx.Message的acknowledge方法,jms服务器才会删除消息;
        // DUPS_OK_ACKNOWLEDGE = 3; 类似auto ack, 自动批量确认消息,具有延迟发送ack的特点,ActiveMq内部实现积累一定数量自动确认.
        // SESSION_TRANSACTED = 0; 这个是给creatSeession(int ack)方法使用,直接设置ack参数,那么前面的true/false则为true.


        //开启事务为true的时候   要commit才可以
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer messageProducer = session.createProducer(queue);

        //  消息持久化
        //  int NON_PERSISTENT = 1; 最多消费一次。这是由于服务器的宕机会造成消息丢失
        //  int PERSISTENT = 2; 消费一次且仅消费一次。可靠性最好，但是占用服务器资源比较多。
        //默认是持久的    搞好数据库持久化后能在数据库里查到消息
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

        for (int i = 1; i <= 3; i++) {
            TextMessage textMessage = session.createTextMessage("你好" + i);
            messageProducer.send(textMessage);
        }
        messageProducer.close();
        session.close();
        connection.close();
    }


}
