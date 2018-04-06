package com.seclab.springbootdemo;

import com.seclab.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

    RedisUtil redisUtil = RedisUtil.getInstance();

    @Test
    public void contextLoads() {
    }

    @Test
    public void stringTest() {
//        redisUtil.saveString("hello", "redis");
//        System.out.println("useRedisDao = " + redisUtil.getString("hello"));
    }
}
