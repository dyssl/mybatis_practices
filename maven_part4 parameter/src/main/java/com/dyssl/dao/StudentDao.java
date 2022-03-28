package com.dyssl.dao;


import com.dyssl.domain.Student;
import com.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectStudentById(Integer id);
    //dao接口的方法形参是一个简单类型
    //简单类型：java基本数据类型和string
    Student selectStudentByEmail(String email);
    //多个简单类型参数
    //使用@Param命名参数，注解是由mybatis提供的
    List<Student> selectStudentByNameOrAge(@Param("studentName") String name, @Param("studentAge") Integer age);
    //java对象来作为参数(对象有属性，每个属性有set，get方法）
    Student selectStudentByObject(Student student);
    Student selectStudentByQueryParam(QueryParam param);
    //使用map传递参数
    List<Student> selectStudentByMap(Map<String,Object> map);
    int updateStudent(Student student);
    //$占位符的使用,使用@Param命名
    List<Student> queryStudent(@Param("studentName") String name);
    List<Student> queryStudentOrderById();
    List<Student> queryStudentByColName(@Param("colName") String name);

}

