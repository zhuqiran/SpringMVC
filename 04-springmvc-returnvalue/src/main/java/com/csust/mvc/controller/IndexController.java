package com.csust.mvc.controller;

import com.csust.mvc.beans.Student;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示控制器方法返回值问题
 * 返回值类型：
 *  1. ModelAndView :表示返回视图和数据，一般在跳转视图并同时展示数据的时候使用该种方式。
 *  2. String(未加@ResponseBody注解) ：表示视图对象，string值为视图的逻辑名称，一般在单纯完成页面跳转时使用。
 *  3. Object : 返回的是数据值，不是视图。返回的值类型可以是：String、List、Map、Integer、自定义类型、二进制数据等等
 *     1)返回该种类型数据，首先要在方法上添加@ResponseBody注解，该注解会将方法的返回值放入到响应体中
 *     2)声明注解驱动
 *      将Object数据转化为 JSON数据，需要由消息转换器 HttpMessageConverter完成。而转
 *      换器的开启，需要由 <mvc:annotation driven/>来完成。
 *      SpringMVC使用消息转换器实现请求数据和对象，处理器方法返回对象和响应输出之间
 *      的自动转换，当Spring容器进行初始化过程中，在 <mvc:annotation driven/>处创建注解驱动时，默认
 *      创建了七个 HttpMessageConverter对象。也就是说，我 们注册 <mvc:annotation driven/>，就
 *      是为了让容器为我们创建 HttpMessageConverter对象。
 *     HTTPMessageConverter接口
 *         HttpMessageConverter接口 : HttpMessageConverter<T>是 Spring3.0 新添加的一个接口，
 *         负责将请求信息转换为一个对象（类型为 T），将对象（类型为 T）输出为响应信息
 *     HTTPMessageConverter接口实现类（具体的转换工作由该接口的实现类完成）:
 *      StringHttpMessageConverter:负责读取字符串格式的数据和写出字符串格式的数据
 *      MappingJackson2HttpMessageConverter:负责读取和写入json格式的数据。利用Jackson的ObjectMapper读写json数据，操作Object类型数据，
 *                                          可读取application/json，响应媒体类型为application/json
 */
@Controller
@RequestMapping(value = "/test")
public class IndexController {
    /**
     * 第二种（2）情况的演示，返回值为String类型，返回视图
     */
    @RequestMapping(value = "/returnView.action")
    public String returnView(){
        // 返回视图逻辑名称字符串
        return "welcome";
    }

    /**
     * 第三种（3）情况的演示，返回值为String
     *
     * StringHttpMessageConverter，此时框架内部使用了这个转换器进行了类型转换，但是它使用的编码集是DEFAULT_CHARSET = StandardCharsets.ISO_8859_1;
     * 所以我们要在响应的时候，设置他的编码集为utf-8
     *  @RequestMapping的 produces属性 指定字符集 。
     *  produces，产品，结果，即该属性用于设置输出结果类型。
     */
    @RequestMapping(value = "/returnString.action", produces = "application/plain;charset=utf-8")
    @ResponseBody
    public String returnStringValue(){
        return "Hello SpringMVC 返回String类型数据";
    }

    /**
     * 第三种（3）情况的演示，返回值为Student自定义对象
     */
    @RequestMapping(value = "/returnObject.action")
    @ResponseBody
    public Student returnObejct(String name, Integer age){
        Student student = new Student(name, age);
        return student;
    }
    /**
     * 第三种（3）情况的演示，返回值为List<Student>
     */
    @RequestMapping(value = "/returnList.action")
    @ResponseBody
    public List<Student> returnList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 23));
        list.add(new Student("lisi", 24));
        return list;
    }
}
