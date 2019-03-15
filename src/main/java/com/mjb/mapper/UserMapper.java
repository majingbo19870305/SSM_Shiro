package com.mjb.mapper;

import com.mjb.pojo.Permission;
import com.mjb.pojo.Role;
import com.mjb.pojo.User;

import java.util.List;

public interface UserMapper {
    public int regUser(User user);
    public User queryUserByUserName(String username);
    public List<Role> queryUserRolesByUserId(int userid);
    public List<Permission> queryUserPermissionByUserid(int userid);
}
