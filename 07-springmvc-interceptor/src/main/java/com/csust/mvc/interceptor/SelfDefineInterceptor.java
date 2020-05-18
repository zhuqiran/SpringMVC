package com.csust.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器对象
 *  1. 实现HandlerInterceptor接口，实现接口中的三个方法。此时该类就是一个SpringMVC支持的拦截器类。
 *  2. 在SpringMVC配置文件中注册该拦截器，并配置拦截资源的URI。
 */
public class SelfDefineInterceptor implements HandlerInterceptor {
    /**
     * 执行时间点：
     *  该方法在处理器方法执行之前执行。
     * 返回结果：
     *  返回结果是Boolean类型，为true表示请求通过拦截器，继续执行处理器方法；为false表示请求被拦截，此次请求结束。
     *  需要注意的是，只有当返回值为true时，拦截器的afterCompletion()方法才会执行。
     * @param httpServletRequest    请求对象
     * @param httpServletResponse   响应对象
     * @param handler   被拦截的处理器对象
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("执行SelfDefineInterceptor拦截器的preHandle方法");
        return true;
    }

    /**
     * 执行时间点：
     *  该方法在处理器方法执行之后执行，无返回值
     * 需要注意的是：
     *  该方法具有ModelAndView参数，所以可以在该方法中对处理器的返回值进行进一步的处理，并且可以修改view的值。
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param modelAndView  处理器方法的返回值
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行SelfDefineInterceptor拦截器的postHandle方法");
    }

    /**
     * 执行时间点：
     *  该方法在请求响应之后执行，无返回值
     * 需要注意的是：
     *  只有preHandle()方法返回true的时候，该方法才能够执行。
     *  我们可以在该方法中定义一些资源释放的操作。
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param ex    异常对象
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object handler, Exception ex) throws Exception {
        System.out.println("执行SelfDefineInterceptor拦截器的afterCompletion方法");
    }
}
