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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void redis1() {
//        redisTemplate.opsForList().leftPushAll("list","java","c");
//        System.out.println(redisTemplate.opsForList().range("list",0,-1));
//
//        redisTemplate.opsForHash().put("map", "key1", "vale1");
//        System.out.println(redisTemplate.opsForHash().get("map", "key1"));
//
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", "1");
//        map.put("3", "1");
//        redisTemplate.opsForHash().putAll("map1", map);
//        System.out.println(redisTemplate.opsForHash().get("map1","1"));
//
//        redisUtils.set("key1", "value1");
//        System.out.println(redisUtils.get("key1"));


//        User user = new User();
//        user.setUserAge("11");
//        user.setUserId("1");
//        user.setUserName("王5");
//        redisTemplate.opsForValue().set("user2",user);
    }
}
