import com.App;
import com.cd.activitimq.controller.ActiveMqController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

//测试activemq
@SpringBootTest(classes = App.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ActiveMqTest {

    @Resource
    private ActiveMqController controller;

    @Test
    public void testSend() throws Exception {
        String id = "123";
        controller.send(id);
    }

    @Test
    public void testSend2() throws Exception {
        controller.sendds();
    }

}
