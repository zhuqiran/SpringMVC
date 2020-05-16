package com.csust.mvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用配置的方式开发SpringMVC
 *  1. 使用配置的方式开发MVC需要实现Controller接口，并实现handleRequest()方法
 *  2. handleRequest()方法，是该控制器实现的唯一方法，用来处理用户的请求。
 */
public class IndexController implements Controller {
    /**
     * handleRequest(),处理用户的请求，并返回处理数据和视图
     * ModelAndView：存放handleRequest方法处理后的数据和视图。
     * Model（M）：存放数据
     * View（V）：设置目标视图
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        ModelAndView mav = new ModelAndView();

        // 添加数据
        // 查看源码ModelMap extends LinkedHashMap<String, Object> ，我们可以知道Model其实质就是一个Map
        // 且值得注意的是，放入Model中的数据，其实最后都被存放到了Request作用域了，比如下面的数据：request.setAttribute("msg", "Hello Spring MVC")
        mav.addObject("msg", "Hello Spring MVC");

        // 设置目标视图
        // 其跳转的方式本质其实为：request.getRequestDispatcher("/show.jsp").forward();即采用请求转发的方式实现页面跳转。
        /*mav.setViewName("/show.jsp");*/
        /*mav.setViewName("/WEB-INF/view/show.jsp");*/
        // 配置完视图解析器后的，视图设置内容
        mav.setViewName("show");
        return mav;
    }
}
