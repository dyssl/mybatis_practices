package com.dyssl;

import com.dyssl.dao.StudentDao;
import com.dyssl.domain.Student;
import com.dyssl.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testSelectById(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
       //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        System.out.println("学生信息："+student);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectStudents(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        for(Student student:students){
            System.out.println("student:"+student);
        }
        //4.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testInsertStudent(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        Student student = new Student();
        student.setId(1004);
        student.setName("duantuicat");
        student.setEmail("duantuicat@qq.com");
        student.setAge(20);
        StudentDao dao = session.getMapper(StudentDao.class);
        int number = dao.insertStudent(student);
        session.commit();
        System.out.println("insert行数："+number);
        //4.关闭SqlSesession对象
        session.close();
    }
}
