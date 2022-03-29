package com.dyssl.dao;


import com.dyssl.domain.Student;
import com.vo.CustomObject;
import com.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectStudentById(Integer id);

    CustomObject selectStudentById2(Integer id);

    CustomObject selectStudentById3(Integer id);
    int countStudent();
    //查询结果返回是一个Map
    Map<Object,Object> selectMap(Integer id);
    //like的第一种方式
    List<Student> selectLikeOne(String name);

}

