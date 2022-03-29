package com.dyssl;

import com.dyssl.dao.ProvinceDao;
import com.dyssl.dao.StudentDao;
import com.dyssl.domain.Student;
import com.dyssl.utils.MyBatisUtil;
import com.vo.CustomObject;
import com.vo.ProvinceCity;
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
    //由于CustomObject对象的属性值与列名不完全匹配，所以只能得到部分数据
    @Test
    public void testSelectById2(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        CustomObject co = dao.selectStudentById2(1001);
        System.out.println("学生信息："+co);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectById3(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        CustomObject co = dao.selectStudentById3(1001);
        System.out.println("学生信息："+co);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testCountStudent(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        int number = dao.countStudent();
        System.out.println("学生数量："+number);
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectMap(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object,Object> map = dao.selectMap(1001);
        System.out.println("map："+map);
        //3.关闭SqlSesession对象
        session.close();
        System.out.println("name:"+map.get("name"));
        System.out.println("id:"+map.get("id"));
    }
    @Test
    public void testSelectProvinceCityList(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        ProvinceDao dao = session.getMapper(ProvinceDao.class);
        List<ProvinceCity> pc = dao.selectProvinceCityList(1);
        pc.forEach(p-> System.out.println(p));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectLikeOne(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectLikeOne("%d%");
        students.forEach(p-> System.out.println(p));
        //3.关闭SqlSesession对象
        session.close();
    }

}
