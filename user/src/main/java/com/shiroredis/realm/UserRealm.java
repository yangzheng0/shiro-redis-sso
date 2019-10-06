package com.shiroredis.realm;

import com.shiroredis.dao.UserMapper;
import com.shiroredis.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm
 * @author jianping.lu
 *
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        // TODO Auto-generated method stub
        System.out.println("认证");
        //shiro判断逻辑
        UsernamePasswordToken user = (UsernamePasswordToken) arg0;
        User newUser = userMapper.selectUserByUsernameAndPassword(user.getUsername(),String.valueOf(user.getPassword()));
        if(newUser == null){
            //用户名错误
            return null;
        }
        return new SimpleAuthenticationInfo(newUser,newUser.getPassword(),"");
    }
}