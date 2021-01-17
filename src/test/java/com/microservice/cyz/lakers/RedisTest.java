package com.microservice.cyz.lakers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author 崔耀中
 * @since 2021-01-10
 */
@SpringBootTest
public class RedisTest {

    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        redisTemplate.opsForSet().add("redisTest","redisTest");
        String s = redisTemplate.opsForSet().pop("redisTest").toString();
        System.out.println(s);

    }
}
