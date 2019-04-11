import com.App;
import com.cd.redis.util.RedisUtils;
import com.cd.shiro.pojo.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class test {
    protected static Logger LOGGER = LoggerFactory.getLogger(test.class);

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public static void main(String[] args) {
        System.out.printf("");
    }


}
