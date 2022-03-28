package com.dyssl;

import com.dyssl.dao.StudentDao;
import com.dyssl.domain.Student;
import com.dyssl.utils.MyBatisUtil;
import com.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testSelectByEmail(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectStudentByEmail("maxia@qq.com");
        System.out.println("学生信息："+student);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectByNameOrAge(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentByNameOrAge("maxia",22);
        students.forEach(student -> System.out.println("学生："+student));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectByObject(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("maxia");
        student.setAge(22);
        Student student_detail = dao.selectStudentByObject(student);
        System.out.println("学生："+student_detail);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testByQueryParam(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setP1("maxia");
        param.setP2(22);
        Student student_detail = dao.selectStudentByQueryParam(param);
        System.out.println("学生："+student_detail);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testByMap(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<String,Object> data = new HashMap<>();
        data.put("studentName","maxia");
        data.put("studentAge", 22);
        List<Student> students = dao.selectStudentByMap(data);
        students.forEach(student -> System.out.println("学生："+student));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testUpdateStudent(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1001);
        student.setAge(23);
        int number = dao.updateStudent(student);
        session.commit();
        System.out.println("number:"+number);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testQueryStudent(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudent("'maxia'");
        students.forEach(student -> System.out.println("学生："+student));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testQueryStudentOrderById(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudentOrderById();
        students.forEach(student -> System.out.println("学生："+student));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testQueryStudentOrderByColName(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudentByColName("name");
        students.forEach(student -> System.out.println("学生："+student));
        //3.关闭SqlSesession对象
        session.close();
    }
}
