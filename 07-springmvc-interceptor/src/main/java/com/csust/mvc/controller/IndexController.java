package com.csust.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class IndexController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        ModelAndView mav = new ModelAndView();
        String msg = "欢迎使用SpringMVC注解式开发方式！--doSome";
        System.out.println(msg);
        // 添加数据
        mav.addObject("msg", msg);

        // 通过设置逻辑名称的方式，设置视图
        mav.setViewName("show");

        return mav;
    }

    @RequestMapping(value = "/index.do")
    public ModelAndView doIndex(){
        ModelAndView mav = new ModelAndView();
        String msg = "欢迎使用SpringMVC注解式开发方式！--doIndex";
        System.out.println(msg);
        // 添加数据
        mav.addObject("msg", msg);

        // 通过设置逻辑名称的方式，设置视图
        mav.setViewName("show");

        return mav;
    }
}
