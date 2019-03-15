package com.mjb.serviceImpl;

import com.mjb.mapper.UserMapper;
import com.mjb.pojo.Permission;
import com.mjb.pojo.Role;
import com.mjb.pojo.User;
import com.mjb.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int regUser(User user) {
        //--1、生成盐:随机 6 位
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<6;i++){
            char c=(char)(int)(Math.random()*26+97);
            sb.append(c);
        }
        String salt = sb.toString();
        //--2、密码加密
        SimpleHash hash = new SimpleHash("MD5",user.getPassword(),salt,3);
        System.out.println(hash.toString());
        user.setPassword(hash.toString());
        user.setSalt(salt);
        return userMapper.regUser(user);
    }

    @Override
    public User queryUserByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }

    @Override
    public List<Role> queryUserRolesByUserId(int userid) {
        return userMapper.queryUserRolesByUserId(userid);
    }

    @Override
    public List<Permission> queryUserPermissionByUserid(int userid) {
        return userMapper.queryUserPermissionByUserid(userid);
    }
}
