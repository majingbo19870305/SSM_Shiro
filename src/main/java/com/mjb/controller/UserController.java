package com.mjb.controller;

import com.mjb.pojo.User;
import com.mjb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("user_reg")
    public ModelAndView reg(User user){
        ModelAndView mav = new ModelAndView();
        int count = userService.regUser(user);
        if(count>0){
            mav.addObject("msg","注册成功!!!");
        }else{
            mav.addObject("msg","注册失败，请重新注册");
        }
        mav.setViewName("result");
        return mav;
    }
    @RequestMapping("user_login")
    public ModelAndView login(User user){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    @RequestMapping("queryAllInfo")
    public ModelAndView queryAllInfo(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allInfo");
        return mav;
    }
}
