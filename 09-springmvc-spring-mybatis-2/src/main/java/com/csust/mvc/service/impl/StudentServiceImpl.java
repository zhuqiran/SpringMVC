package com.csust.mvc.service.impl;

import com.csust.mvc.beans.Student;
import com.csust.mvc.dao.IStudentDao;
import com.csust.mvc.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentDao studentDao;

    @Override
    public List<Student> findAllStudents() {
        return studentDao.selectAllStudents();
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }
}
