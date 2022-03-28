package com.dyssl;

import com.dyssl.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    //测试mybatis执行sql语句
    @Test
    public void testSelectStudentById() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //指定要执行的sql语句的id
        //sql的id = namespace+'.'+select|update|insert|delete标签的id属性
        String sqlId = "com.dyssl.dao.StudentDao" + '.' + "selectStudentById";
        //通过sqlsession执行sql语句
        Student student = session.selectOne(sqlId,1002);
        System.out.println("使用mybatis查询一个学生：" + student);
        //关闭sqlsession对象
        session.close();
    }
    @Test
    public void testInsertStudent() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        String sqlId = "com.dyssl.dao.StudentDao" + '.' + "insertStudent";
        Student student = new Student();
        student.setId(1003);
        student.setName("maxia");
        student.setEmail("maxia@qq.com");
        student.setAge(22);
        int rows = session.insert(sqlId,student);
        System.out.println("使用mybatis添加一个学生，rows：" + rows);
        //mybatis默认执行sql语句是手工提交事务模式，在做insert，update，delete后需要提交事务
        session.commit();
        session.close();
    }
}
