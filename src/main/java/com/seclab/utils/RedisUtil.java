package com.seclab.utils;

import com.seclab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:42
 * Description:
 */
public class RedisUtil {

    public static final String REDIS_KEY_USER = "key_user:";

    private volatile static RedisUtil instance;

    public static RedisUtil getInstance() {
        if (instance == null) {
            synchronized (RedisUtil.class) {
                if (instance == null) {
                    instance = new RedisUtil();
                }
            }
        }
        return instance;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Resource(name = "stringRedisTemplate")
//    ValueOperations<String, String> stringValueOperations;
//
//    @Resource(name = "redisTemplate")
//    ValueOperations<String, Object> valueOperations;

    /**
     * 缓存一个user
     *
     * @param user
     */
    public void saveUser(User user) {
        redisTemplate.opsForValue().set(REDIS_KEY_USER + user.getId(), user);
    }

    /**
     * 从缓存中获取一个user
     *
     * @return
     */
    public User getUser(Long key) {
        System.out.println("redisTemplate:" + redisTemplate);
        return (User) redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取一个字符串
     *
     * @param key
     * @return
     */
//    public String getString(String key) {
//        return stringValueOperations.get(key);
//
//    }
//
//    public void saveString(String key, String value) {
//        stringValueOperations.set(key, value);
//    }
}
