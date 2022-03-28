package com.dyssl;

import com.dyssl.dao.StudentDao;
import com.dyssl.dao.impl.StudentDaoImpl;
import com.dyssl.domain.Student;
import org.junit.Test;

import java.util.List;
//使用dao代理的要求：1.mapper文件中的namespace必须是dao接口的全限名称
//2.mapper文件中标签的id得是dao接口中的方法名称
public class MyTest2 {
    @Test
    public void testSelectOne(){
        //使用dao方法
        StudentDao dao = new StudentDaoImpl();
        Student student = dao.selectById(1001);
        System.out.println("通过dao执行方法得到的对象："+student);
    }
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.selectStudents();
        for(Student student:students){
            System.out.println("通过dao执行方法学生信息："+student);
        }
    }
    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1004);
        student.setName("duantuicat");
        student.setEmail("duantuicat@qq.com");
        student.setAge(20);
        int number = dao.insertStudent(student);
        System.out.println("影响的行数："+number);
    }
}
