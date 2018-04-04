package com.seclab.service;

import com.seclab.annotation.DataSource;
import com.seclab.datasource.CustomContextHolder;
import com.seclab.domain.User;
import com.seclab.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserMapper userMapper;

    @DataSource(CustomContextHolder.DATA_SOURCE_MASTER)
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @DataSource(CustomContextHolder.DATA_SOURCE_SLAVER)
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
