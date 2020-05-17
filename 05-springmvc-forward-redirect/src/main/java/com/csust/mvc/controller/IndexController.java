package com.csust.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

/**
 * 演示在SpringMVC矿建中如何进行请求转发和重定向操作
 *  请求转发（forward）：可以转发到视图和控制器
 *    语法：
 *     转发到视图：forward:完整的视图路径（这里注意要使用完整的视图路径，因为forward操作和视图解析器不共同工作，即视图解析器不会解析forward的路径）
 *     转发到控制器：forward:完整的控制器路径
 *  重定向（redirect）：可以重定向到视图和控制器
 *    语法：
 *      重定向到视图：redirect:完整的视图路径（这里注意要使用完整的视图路径，因为forward操作和视图解析器不共同工作，即视图解析器不会解析forward的路径）
 *      重定向到控制器：redirect:完整的控制器路径
 *      需要注意的是，在重定向时，若需要携带参数，则参数存放在请求的后面即：http://localhost:8080/other.action?param=value
 */
@Controller
@RequestMapping(value = "/test")
public class IndexController {

    /**
     * 请求转发到视图
     * forward:完整路径名
     */
    @RequestMapping(value = "/forwardToView.action")
    public ModelAndView forwardToView(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        // 请求转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }

    /**
     *  请求转发到控制器
     */
    @RequestMapping(value = "/forwardToController.action")
    public ModelAndView forwardToController(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);

        //请求转发到控制器方法
        mv.setViewName("forward:/test/processForward.action");
        return mv;
    }

    // 控制器方法
    @RequestMapping(value = "/processForward.action")
    public String processForward(){

        // 转发到show.jsp页面
        return "show";
    }

    /**
     * 重定向到视图
     *  语法：redirect:完整路径名
     * 需要注意的是，重定向时，是无法重定向到受保护视图的，即web-inf目录下定义的视图。
     */
    @RequestMapping(value = "/redirectToView.action")
    public ModelAndView redirectToView(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);

        // 重定向到视图
        // mv.setViewName("redirect:/WEB-INF/view.show.jsp");      // 无法重定向成功，show.jsp是受保护视图
        mv.setViewName("redirect:/welcome.jsp");

        // 参数传递，model中的数据是这样传递的：（需要注意的是，只有基本类型和包装类型能这么传。自定义类型是识别不了的，无法传递）
        // http://localhost:8080/05_springmvc_forward_redirect/welcome.jsp?name=zs&age=12

        return mv;
    }

    /**
     * 重定向到控制器
     */
    @RequestMapping(value = "/redirectToController.action")
    public ModelAndView redirectToController(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);

        // 重定向到控制器
        mv.setViewName("redirect:/test/processRedirect.action");
        return mv;
    }

    @RequestMapping(value = "/processRedirect.action")
    public ModelAndView processRedirect(String name, Integer age){
        ModelAndView mv = new ModelAndView();

        mv.addObject("name", name);
        mv.addObject("age", age);

        mv.setViewName("show");

        return mv;
    }

}
