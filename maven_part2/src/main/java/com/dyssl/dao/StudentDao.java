package com.dyssl.dao;


import com.dyssl.domain.Student;

import java.util.List;

public interface StudentDao {
    Student selectById(int id);

    List<Student> selectStudents();

    int insertStudent(Student student);
}
