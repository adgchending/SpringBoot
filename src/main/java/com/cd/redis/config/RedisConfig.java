
package com.cd.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Arrays;


/**
 * @Param:描述:Redis基于注解开发的配置类 缓存注解有以下三个：
 * {
 * @Cacheable:应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
 * @CacheEvict:应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
 * @CachePut:应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存 }
 * @return：返回结果描述:
 * @Throws：返回异常结果:
 * @Author: chenshangxian
 * @Date: 2018-11-16 13:37
 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @SuppressWarnings("rawtypes")
    @Bean
    //redis的注解开发配置
    //参数名必须为redisTemplate,有待研究~~~
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        // 多个缓存的名称,目前只定义了一个
        rcm.setCacheNames(Arrays.asList("redis1"));
        //设置缓存过期时间(秒)
        rcm.setDefaultExpiration(600);
        return rcm;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(factory);
         /*
        推荐使用stringSerializer序列化的方式
         */
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);//这个鬼改成jackson2JsonRedisSerializer才能存对象,待探究
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);
        template.afterPropertiesSet();
        return template;
    }
}

