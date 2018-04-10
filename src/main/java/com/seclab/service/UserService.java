package com.seclab.service;

import com.seclab.annotation.DataSource;
import com.seclab.domain.User;
import com.seclab.datasource.CustomContextHolder;
import com.seclab.mapper.RoleMapper;
import com.seclab.mapper.UserMapper;
import com.seclab.security.SimpleAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 10:28
 * Description:
 */

/**
 * 用了缓存之后如果数据库内容修改了，可能会造成下次读取脏数据的情况
 * 因为缓存的内容不一定和数据库一致
 * <p>
 * 可以用这种注解的方式缓存，比较方便，这种注解在redis中有缓存的情况下会拦截方法不调用
 * 但是需要注意缓存和数据库数据的一致性，更新了数据库要么删除缓存要么更新缓存，并且是一个事务
 *
 * @Cacheable(value = "user", keyGenerator = "keyGenerator")
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

//    @DataSource(CustomContextHolder.DATA_SOURCE_SLAVER)
    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

//    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    @Cacheable(value = "user", keyGenerator = "keyGenerator")
    @Override
    public User selectUserById(Long id) {
        User user = userMapper.selectUserById(id);
//        redisTemplate.opsForValue().set(StaticParams.Constants.KEY_USER_INFO_PREFIX + user.getUsername() + ":" + user.getId(), user);
        return user;
    }

//    @DataSource(CustomContextHolder.DATA_SOURCE_SLAVER)
    @Cacheable(value = "user", keyGenerator = "keyGenerator")
    @Override
    public User selectUserByUsername(String username) {
        User user = userMapper.selectUserByUsername(username);
//        redisTemplate.opsForValue().set(StaticParams.Constants.KEY_USER_INFO_PREFIX + user.getUsername() + ":" + user.getId(), user);
        return user;
    }

    @Override
    public Page<User> selectUsersByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public Integer updateUser(User User) {
        return null;
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
