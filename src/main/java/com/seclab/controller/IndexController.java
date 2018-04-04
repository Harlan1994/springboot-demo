package com.seclab.controller;

import com.seclab.domain.User;
import com.seclab.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 11:37
 * Description:
 */
@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public @ResponseBody List<User> index() {
        List<User> users = userService.getAll();
        return users;
    }

//    @DeleteMapping("/user/{id}")
//    public void delete(@Param("id") Long id) {
//        userService.delete(id);
//    }
}
