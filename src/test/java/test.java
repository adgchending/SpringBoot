import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


@SpringBootTest
public class test {
    protected static Logger LOGGER = LoggerFactory.getLogger(test.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void t1() {
        System.out.println("222");
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("testkey", "testvalue");
        String testkey = stringStringValueOperations.get("testkey");
        LOGGER.info(testkey);
    }
}
