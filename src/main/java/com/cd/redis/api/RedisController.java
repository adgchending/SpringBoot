package com.cd.redis.api;

import com.cd.redis.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@Api(tags = "redis相关操作")
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtils redisUtils;

    /**
     * @Param:描述:key值里面的#号代表这是一个SpEL表达式，此表达式可以遍历方法的参数对象，具体语法可以参考Spring的相关文档手册。
     * @return：返回结果描述:
     * @Throws：返回异常结果:操作对象和string类型暂时只能选其一
     * @Author: chenshangxian
     * @Date: 2018-11-16 17:23
     */
//    @ApiOperation(value = "加数据到redis")
//    @GetMapping("/add")
//    @Cacheable(value = "redis1", key = "id")
//    public String add(@RequestParam String id) {
//
//        return id;
//    }
//
//    @ApiOperation(value = "从redis删除数据")
//    @GetMapping("/delete")
//    @CacheEvict(value = "redis1", key = "id")
//    public void delete(@RequestParam String id) {
//    }
    @ApiOperation(value = "获取数据")
    @GetMapping("/get")
    public String get(@ApiParam("redis的key") @RequestParam String key) {
        return redisUtils.get(key);
    }

    @ApiOperation(value = "添加数据")
    @GetMapping("/add")
    public void add(@ApiParam("key值") @RequestParam String key, @ApiParam("value值") @RequestParam String value) {
        redisUtils.set(key, value);
    }

    @ApiOperation(value = "删除数据")
    @GetMapping("/delete")
    public void add(@ApiParam("redis的key") @RequestParam String key) {
        redisUtils.delete(key);
    }
}
