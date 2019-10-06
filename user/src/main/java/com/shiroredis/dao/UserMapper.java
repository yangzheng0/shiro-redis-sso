package com.shiroredis.dao;

import com.shiroredis.entity.User;

public interface UserMapper {
    User selectUserByUsernameAndPassword(String username,String password);
}
