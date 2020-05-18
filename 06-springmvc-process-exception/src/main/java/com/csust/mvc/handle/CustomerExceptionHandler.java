package com.csust.mvc.handle;

import com.csust.mvc.controller.IndexController;
import com.csust.mvc.exception.AgeException;
import com.csust.mvc.exception.NameException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 *  1. 需要实现HandlerExceptionResolver接口
 *  2. 实现HandlerExceptionResolver接口的resolveException()方法。
 *      异常的处理逻辑就定义在这个方法中
 */
public class CustomerExceptionHandler implements HandlerExceptionResolver {
    /**
     * 异常处理方法
     * @param httpServletRequest    请求对象
     * @param httpServletResponse   响应对象
     * @param handle    发生异常的Controller对象
     * @param ex        发生异常的异常对象，我们可以通过对ex进行判断，从而确认发送的是何种异常，然后进行相应的异常处理
     * @return 返回视图，展示异常处理的结果
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object handle, Exception ex) {
        System.out.println(handle instanceof IndexController);
        ModelAndView mv = new ModelAndView();
        // 判断异常的类型，做对应的处理
        if(ex instanceof NameException){
            mv.addObject("tips", "你的用户名输入可能出现错误！CustomerExceptionHandler自定义异常处理器。");
            mv.addObject("ex", ex);
            mv.setViewName("nameError");
        }else if(ex instanceof AgeException){
            mv.addObject("tips", "可能是你的年龄输入存在问题！CustomerExceptionHandler自定义异常处理器。");
            mv.addObject("ex", ex);
            mv.setViewName("ageError");
        }else{
            // 其他类型的异常
            mv.addObject("tips", "您的请求已提交，请稍后再试！");
            mv.addObject("ex", ex);
            mv.setViewName("defaultError");
        }
        return mv;
    }
}
