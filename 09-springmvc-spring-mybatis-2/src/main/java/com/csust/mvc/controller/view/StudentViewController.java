package com.csust.mvc.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器只进行Student模块的s页面跳转功能
 */
@Controller
@RequestMapping(value = "/view")
public class StudentViewController {

    @RequestMapping(value = "/addStudent.action")
    public String pageToAddStudent(){
        return "addStudent";
    }

    @RequestMapping(value = "/listStudent.action")
    public String pageToListStudent(){
        return "listStudent";
    }
}
