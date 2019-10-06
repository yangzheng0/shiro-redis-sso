package com.shiroredis.controller;

import com.shiroredis.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public User login(@RequestParam(value = "username") String username,
                      @RequestParam(value = "password") String password){
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username, password));
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

    @RequestMapping("/logout")
    public Boolean logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return true;
    }

    @RequestMapping("/get")
    public User get(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

}
