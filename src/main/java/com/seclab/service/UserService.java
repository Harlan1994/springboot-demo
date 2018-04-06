package com.seclab.service;

import com.seclab.annotation.DataSource;
import com.seclab.domain.User;
import com.seclab.domain.datasource.CustomContextHolder;
import com.seclab.mapper.UserMapper;
import com.seclab.security.SimpleAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 10:28
 * Description:
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    @Cacheable(value = "user", keyGenerator = "keyGenerator")
    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @DataSource(CustomContextHolder.DATA_SOURCE_SLAVER)
    @Cacheable(value = "user", keyGenerator = "keyGenerator")
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    @Cacheable(value = "users", keyGenerator = "keyGenerator")
    @Override
    public Page<User> findByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public void update(User User) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Autowired
    private SimpleAuthenticationProvider simpleAuthenticationProvider;

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
