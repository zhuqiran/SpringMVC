package com.csust.mvc.service;

import com.csust.mvc.beans.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAllStudents();
    int addStudent(Student student);
}
