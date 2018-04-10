package com.seclab.service;

import com.seclab.domain.User;
import org.springframework.data.domain.Page;

public interface IUserService {

    Integer insertUser(User user);

    User selectUserById(Long id);

    User selectUserByUsername(String username);

    Page<User> selectUsersByPage(Integer page, Integer size);

    Integer updateUser(User User);

    void deleteById(Long id);

    User login(User user);

    boolean logout();
}
