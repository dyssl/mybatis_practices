package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 *
 */
public interface StudentDao {
    //if
    List<Student> selectIf(Student student);

    //where
    List<Student> selectWhere(Student student);

    //foreach-1
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach-2
    List<Student> selectForeachTwo(List<Student> studentList);


    List<Student> selectAllStudents();
}
