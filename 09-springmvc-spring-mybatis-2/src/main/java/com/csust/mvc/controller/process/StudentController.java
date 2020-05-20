package com.csust.mvc.controller.process;

import com.csust.mvc.beans.Student;
import com.csust.mvc.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/process")
public class StudentController {
    // 注入Service对象
    @Resource
    private IStudentService service;

    @RequestMapping(value = "/addStudent.action")
    @ResponseBody
    public ModelAndView addStudent(Student student){     // 使用对象的形式，接收请求参数
        ModelAndView mv = new ModelAndView();
        if(student != null){
            int count = service.addStudent(student);
            if(count > 0){
                mv.setViewName("redirect:/view/listStudent.action");
                return mv;
            }
        }
        mv.setViewName("redirect:/view/addStudent.action");
        return mv;
    }

    @RequestMapping(value = "/listStudent.action")
    @ResponseBody
    public List<Student> listStudent(){
        List<Student> list = service.findAllStudents();
        return list;
    }
}

