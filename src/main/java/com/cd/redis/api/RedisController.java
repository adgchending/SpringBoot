package com.cd.redis.api;

import com.cd.basic.pojo.vo.UserVo;
import com.cd.common.util.Result;
import com.cd.common.util.ResultUtil;
import com.cd.redis.util.RedisUtils;
import com.cd.shiro.pojo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@Api(tags = "redis")
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtils redisUtils;

    /**
     * @Param:描述:key值里面的#号代表这是一个SpEL表达式，此表达式可以遍历方法的参数对象，具体语法可以参考Spring的相关文档手册。
     * @return：返回结果描述:
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-11-16 17:23
     */
    @ApiOperation(value = "加数据到redis")
    @PostMapping("/add")
    @Cacheable(value = "redis1", key = "#vo.id")
    public Result add(@RequestBody UserVo vo) {
        User user = new User();
        user.setUserId(vo.getId());
        user.setUserName(vo.getName());
        user.setUserAge(vo.getAge());
        return ResultUtil.success(user);
    }

    @ApiOperation(value = "从redis删除数据")
    @PostMapping("/delete")
    //@CacheEvict(value = "redis1", key = "#vo.id")
    public Result delete(@RequestBody UserVo vo) {
        redisTemplate.opsForValue().set("user",vo);

        String id = vo.getId();
        return ResultUtil.success(id);
    }

    /*@ApiOperation(value = "操作String")
    @PostMapping("/String")
    public Result redis1() {
        redisTemplate.opsForValue().append("name","hello ");
        System.out.println(redisTemplate.opsForValue().get("name"));
        redisTemplate.opsForValue().append("name","world");
        System.out.println(redisTemplate.opsForValue().get("name"));
        return ResultUtil.success(redisTemplate.opsForValue().get("name"));
    }*/

}
