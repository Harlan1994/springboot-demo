package com.seclab.controller;

import com.seclab.domain.RequestUser;
import com.seclab.domain.ResultEnum;
import com.seclab.domain.Role;
import com.seclab.domain.User;
import com.seclab.exception.UserNotFoundException;
import com.seclab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

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

//    @GetMapping("/user/{page}")
//    public @ResponseBody
//    Page<User> getAll(@PathVariable("page") Integer page) {
//        return userService.selectUsersByPage(page, 15);
//    }

//    @GetMapping("/user/insert")
//    public String insert(ModelAndView modelAndView) {
////        System.out.println("inserted username:" + user.getUsername());
////        Integer result = userService.insertUser(user);
////        System.out.println("result:" + result);
//        return "user";
//    }

    @GetMapping("/user")
    public String login(ModelAndView modelAndView) {
        modelAndView.addObject("key", "value");
        return "pages/user.html";
    }

    // @RequestParam("username") String username,
    //                @RequestParam("password") String password,
    //                @RequestParam("birthday") String birthday,
    //                @RequestParam("realName") String realName
    @PostMapping("/user")
    public @ResponseBody
    User insert(@RequestBody RequestUser requestUser) {
        User user = new User();
        user.setUsername(requestUser.getUsername());
        user.setPassword(requestUser.getPassword()); // TODO: 2018/4/9 密码的保存需要特殊处理
        user.setBirthday(requestUser.getBirthday());
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setBirthday(birthday);
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER"));
        user.setRoles(roles);
        user.setRealName(requestUser.getRealName());
//        user.setRealName(realName);
        user.setLocked(false);
        Integer result = userService.insertUser(user);
        System.out.println("result:" + result);
        return user;
    }

    /**
     * 获取某个用户的json数据
     *
     * @param username
     * @return
     */
    @GetMapping("/user/{username}")
    public @ResponseBody
    User profile(@PathVariable("username") String username) {
        User user = userService.selectUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(ResultEnum.USER_NOT_FOUND, "username=" + username);
        }
        return user;
    }

//    @GetMapping(value = "/user/{id}")
//    public @ResponseBody
//    User profile(@PathVariable("id") Long id) {
//        User user = userService.findById(id);
//        if (user == null) {
//            throw new UserNotFoundException(ResultEnum.USER_NOT_FOUND, "id=" + id);
//        }
//        return user;
//    }

//    /**
//     * 更新用户信息，支持realName等属性的更新
//     *
//     * @param user
//     * @return
//     */
//    @PutMapping(value = "/user")
//    public int updateUser(User user) {
//        Integer result = userService.update(user);
//        return result;
//    }
}
