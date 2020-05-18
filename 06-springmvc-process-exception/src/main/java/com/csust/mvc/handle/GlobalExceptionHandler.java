package com.csust.mvc.handle;

import com.csust.mvc.exception.AgeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @ControllerAdvice    控制器增强
//                      控制器发生异常可以到该类中寻找ExceptionHandler
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 定义异常处理方法
     * 使用@ExceptionHandler注解修饰的方法就是异常处理方法。
     * value属性：异常类型的class。表示要处理的异常映射
     *
     * @param request
     * @param response
     * @param ex
     */
    @ExceptionHandler(value = AgeException.class)      // 表示处理的异常为NameException
    public ModelAndView processAgeException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips", "您的年龄可能超出了限制！");
        mv.addObject("ex", ex);
        mv.setViewName("ageError");
        return mv;
    }

    /**
     * 定义异常处理方法
     * 使用@ExceptionHandler注解修饰的方法就是异常处理方法。
     * value属性：异常类型的class。表示要处理的异常映射
     *
     * @param request
     * @param response
     * @param ex
     */
    @ExceptionHandler    // 不指定value属性值，则表示处理默认的异常。此种类型的异常处理方法只能存在一个
    public ModelAndView processDefaultException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips", "您的请求已提交，情稍后再试！");
        mv.addObject("ex", ex);
        mv.setViewName("defaultError");
        return mv;
    }

}
