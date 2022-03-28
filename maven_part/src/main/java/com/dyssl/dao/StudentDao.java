package com.dyssl.dao;

import com.dyssl.domain.Student;

public interface StudentDao {
    //查询一个学生
    Student selectStudentById(Integer id);
    //添加学生,返回值表示本次操作影响的数据库行数
    int insertStudent(Student student);
}
