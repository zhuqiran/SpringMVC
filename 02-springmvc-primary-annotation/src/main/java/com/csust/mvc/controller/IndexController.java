package com.csust.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class IndexController {

    /**
     * /user/doSome.do
     * method属性：表示当前处理器方法能接收的请求类型
     */
    @RequestMapping(value = "/doSome.do", method = RequestMethod.GET)
    public ModelAndView doSome(){
        ModelAndView mav = new ModelAndView();
        // 添加数据
        mav.addObject("msg", "欢迎使用SpringMVC注解式开发方式！--doSome");

        // 通过设置逻辑名称的方式，设置视图
        mav.setViewName("show");

        return mav;
    }
    /**
     * /user/doOther.do
     * method属性：表示当前处理器方法能接收的请求类型
     */
    @RequestMapping(value = "/doOther.do", method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mav = new ModelAndView();
        // 添加数据
        mav.addObject("msg", "欢迎使用SpringMVC注解式开发方式！--doOther");

        // 通过设置逻辑名称的方式，设置视图
        mav.setViewName("show");

        return mav;
    }

    /**
     * /user/doThird.do
     * method属性：表示当前处理器方法能接收的请求类型， 如果不指定的话，则表示不限制请求类型。即各种请求类型都是支持的
     */
    @RequestMapping(value = "/doThird.do")
    public ModelAndView doThird(){
        ModelAndView mav = new ModelAndView();
        // 添加数据
        mav.addObject("msg", "欢迎使用SpringMVC注解式开发方式！--doThird");

        // 通过设置逻辑名称的方式，设置视图
        mav.setViewName("show");

        return mav;
    }
}
