package com.cd.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    public void m (){
        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
    }



}
