package com.seclab.controller;

import com.seclab.domain.ResultEnum;
import com.seclab.domain.User;
import com.seclab.exception.UserNotFoundException;
import com.seclab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:24
 * Description:
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users/{page}")
    public @ResponseBody
    Page<User> getAll(@PathVariable("page") Integer page) {
        return userService.findByPage(page, 15);
    }

    /**
     * 获取某个用户的json数据
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public @ResponseBody
    User get(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new UserNotFoundException(ResultEnum.USER_NOT_FOUND);
        }

        return user;
    }

    /**
     * 获取用户资料，并返回放入了用户资料数据的页面
     *
     * @param username
     * @param modelAndView
     * @return
     */
    @GetMapping(value = "/user/profile/{username}")
    public String profile(@PathVariable("username") String username, ModelAndView modelAndView) {
        User user = userService.findUserByUsername(username);
        if (user != null) {
            modelAndView.addObject("userInfo", user);
            return "user";
        }

        // TODO: 2018/4/6 此处逻辑还得该，统一处理查找不到或者查找失败或者超查找时出现异常的处理模式
        return null;
    }
}
