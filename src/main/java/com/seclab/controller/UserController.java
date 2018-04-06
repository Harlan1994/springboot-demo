package com.seclab.controller;

import com.seclab.domain.ResultEnum;
import com.seclab.domain.User;
import com.seclab.exception.UserNotFoundException;
import com.seclab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:24
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/user/{id}")
    public User get(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException(ResultEnum.USER_NOT_FOUND);
        }

        return user;
    }
}
