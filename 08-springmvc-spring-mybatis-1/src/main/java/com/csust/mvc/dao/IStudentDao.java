package com.csust.mvc.dao;

import com.csust.mvc.beans.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> selectAllStudents();
    int insertStudent(Student student);
}
