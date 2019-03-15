package com.mjb.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorizationController {
    // 角色控制
    // @RequiresRoles({"admin"})
    // 权限控制
    @RequiresPermissions({"add"})
    @RequestMapping("add")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","添加成功！！！");
        mav.setViewName("result");
        return mav;
    }
    // @RequiresRoles({"manager"})
    @RequiresPermissions({"del"})
    @RequestMapping("del")
    public ModelAndView del(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","删除成功！！！");
        mav.setViewName("result");
        return mav;
    }
    // @RequiresRoles({"admin"})
    @RequiresPermissions({"update"})
    @RequestMapping("update")
    public ModelAndView update(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","修改成功！！！");
        mav.setViewName("result");
        return mav;
    }
    //@RequiresRoles({"nornal"})
    @RequiresPermissions({"query"})
    @RequestMapping("query")
    public ModelAndView query(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","查询成功！！！");
        mav.setViewName("result");
        return mav;
    }
}
