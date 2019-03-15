package com.mjb.shiro;

import com.mjb.pojo.Permission;
import com.mjb.pojo.Role;
import com.mjb.pojo.User;
import com.mjb.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public String getName() {
        return "CustomRealm";
    }

    /*
        授权
         */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //-获得当前的登录用户
        User user = (User)principalCollection.getPrimaryPrincipal();
        System.out.println("user===》"+user);

        //--权限信息对象info，用来存放查出来的用户所有角色(role)及权限(permission)
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //-查询当前用户的角色
        List<Role> roleList = userService.queryUserRolesByUserId(user.getId());
        System.out.println(roleList);
        // 将查询到的角色添加到info对象中
        for(Role role:roleList){
            info.addRole(role.getName()+"");
        }
        //查询当前用户的权限
        List<Permission> permissionList = userService.queryUserPermissionByUserid(user.getId());
        System.out.println(permissionList);
        // 将查询到的权限添加到info对象中
        for(Permission permission:permissionList){
            info.addStringPermission(permission.getName()+"");
        }
        return info;
    }
    /*
    认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        /**
         * 此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息
         *
         */
        String username = usernamePasswordToken.getUsername();
        User user = userService.queryUserByUserName(username);
        if(user==null){
            return null;
        }
        /**
         * 参数解读：
         *      1、对象
         *      2、密码
         *      3、盐
         *      4、当前类name
         */
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        return simpleAuthenticationInfo;
    }
}
