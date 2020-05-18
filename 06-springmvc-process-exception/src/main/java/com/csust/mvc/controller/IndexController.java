package com.csust.mvc.controller;

import com.csust.mvc.exception.AgeException;
import com.csust.mvc.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/test")
public class IndexController {

    @RequestMapping(value = "/process.action")
    public ModelAndView processRedirect(String name, Integer age) throws NameException, AgeException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        // 抛出的异常会被SpringMVC框架捕获到，然后将捕获到的异常交给异常处理器处理
        if(! "zs".equals(name)){
            // 抛出异常
            throw new NameException("您输入的用户名有误！");
        }
        if(age > 80){
            throw new AgeException("不好意思，您的年龄超了！");
        }

        mv.setViewName("show");
        System.out.println("你好的-------");

        return mv;
    }
}
