package com.seclab.service;

import com.seclab.annotation.DataSource;
import com.seclab.domain.User;
import com.seclab.domain.datasource.CustomContextHolder;
import com.seclab.mapper.UserMapper;
import com.seclab.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 10:28
 * Description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

//    RedisUtil redisUtil = RedisUtil.getInstance();

    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    @Cacheable(value = "users", keyGenerator = "keyGenerator")
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    @Cacheable(value = "user", keyGenerator = "keyGenerator")
    public User getUser(Long id) {
        return userMapper.findById(id);
    }
}
