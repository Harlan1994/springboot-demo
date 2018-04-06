package com.seclab.service;

import com.seclab.domain.User;
import org.springframework.data.domain.Page;

public interface IUserService {

    User findById(Long id);

    User findUserByUsername(String username);

    Page<User> findByPage(Integer page, Integer size);

    void update(User User);

    void deleteById(Long id);

    User login(User user);

    boolean logout();
}
