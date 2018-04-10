package com.seclab.controller;

import com.seclab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/")
    public String index(ModelAndView modelAndView) {
        return "pages/index.html";
    }

    /**
     * 进入登陆界面
     *
     * @return
     */
    @GetMapping("/login")
    public String login(ModelAndView modelAndView) {
        modelAndView.addObject("key", "value");
        return "pages/login.html";
    }

    @GetMapping("/error")
    public String error(ModelAndView modelAndView){
        return "pages/error.thml";
    }
}
