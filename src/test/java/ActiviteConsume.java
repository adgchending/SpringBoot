import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @类名:ActiviteConsume
 * @类描述:Active消费消息
 * @创建日期: 2022/3/14
 * @修改记录: <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: csx
 */
public class ActiviteConsume {

    public static final String URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "csx_01";


    //消息的消费者
    public static void main(String[] args) throws JMSException {
        //创建连接工厂,给指定的url,采用默认的账号和密码 admin  admin
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        //通过连接工厂获得conntction
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3创建session
        //两个参数  一个叫事务/第二个叫签收    (事务比签收大:  开启事务但是不commit()的情况下, 开启签收还是会出现重复消费的情况.)
        // 第一个事务开启的情况下  要进行commit  ( //session.commit();)
        // 如果是手动签收(Session.CLIENT_ACKNOWLEDGE)的情况 需要对消息进行ack方法 (//receive.acknowledge(););
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4创建连接池
        Queue queue = session.createQueue(QUEUE_NAME);
        //5创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        while (true) {
            //一直等,可加参数
            TextMessage receive = (TextMessage) messageConsumer.receive(3000);
            receive.acknowledge();
            if (null != receive) {
                System.out.println("消费者接受到的消息:" + receive.getText());
                //   手动签收需要调用此方法      receive.acknowledge();
            } else {
                break;
            }
        }
        messageConsumer.close();
        //session.commit();
        session.close();
        connection.close();
    }
}
