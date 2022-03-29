package com.dyssl.dao;


import com.dyssl.domain.Student;

import java.util.List;

public interface StudentDao {
    //if
    List<Student> selectIf(Student student);

    //where
    List<Student> selectWhere(Student student);

    //foreach
    List<Student> selectForeachOne(List<Integer> idlist);

    List<Student> selectForeachTwo(List<Student> studentList);

    List<Student> selectAllStudents();

}

