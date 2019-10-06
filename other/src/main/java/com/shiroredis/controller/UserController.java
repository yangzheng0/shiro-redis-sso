package com.shiroredis.controller;

import com.shiroredis.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get")
    public User get(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

}
