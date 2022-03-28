package com.dyssl;

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
        //2.指定sqlid
        String sqlid = "com.dyssl.dao.StudentDao.selectStudentById";
        //3.执行sqlsession方法，表示执行sql语句
        Student student = session.selectOne(sqlid,1001);
        System.out.println("查询的结果："+student);
        //4.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectStudents(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.指定sqlid
        String sqlid = "com.dyssl.dao.StudentDao.selectStudents";
        //3.执行sqlsession方法，表示执行sql语句
        List<Student> students = session.selectList(sqlid);
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
        //2.指定sqlid
        String sqlid = "com.dyssl.dao.StudentDao.insertStudent";
        //3.执行sqlsession方法，表示执行sql语句
        Student student = new Student();
        student.setId(1005);
        student.setName("duantuicat");
        student.setEmail("duantuicat@qq.com");
        student.setAge(20);
        int number = session.insert(sqlid,student);
        session.commit();
        System.out.println("insert行数："+number);
        //4.关闭SqlSesession对象
        session.close();
    }
}
