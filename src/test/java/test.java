import com.cd.basic.pojo.bo.StudentBo;
import com.cd.redis.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)
public class test {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    public static void main(String[] args) throws SQLException {
        List<StudentBo> bos = new ArrayList<>();
        //新增10W条数据耗时13秒
        for (int i = 0; i <100000 ; i++) {
            String name = "张三"+i;
            StudentBo studentBo = new StudentBo();
            studentBo.setName(name);
            studentBo.setAge(i);
            bos.add(studentBo);
        }


        long start = System.currentTimeMillis();
        System.out.println(start);
        Connection conn = null;
        String url  = "jdbc:mysql://127.0.0.1:3306/springboot?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        PreparedStatement ps = null;
        String sql = "insert into thread VALUES (?,?)";
        // 批量插入时ps对象必须放到for循环外面
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < bos.size(); i++) {
            ps.setString(1, bos.get(i).getName());
            ps.setInt(2, bos.get(i).getAge());

            ps.addBatch();
            if (i % 1000 == 0) {
                ps.executeBatch();
                conn.commit();
                ps.clearBatch();
            }
        }
        // 剩余数量不足1000
        ps.executeBatch();
        conn.commit();
        ps.clearBatch();
        long end = System.currentTimeMillis();
        System.out.println(((end - start) / 1000) + "秒");
    }


}
