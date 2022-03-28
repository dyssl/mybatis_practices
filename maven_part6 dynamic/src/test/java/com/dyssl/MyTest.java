package com.dyssl;

import com.dyssl.dao.StudentDao;
import com.dyssl.domain.Student;
import com.dyssl.utils.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.vo.CustomObject;
import com.vo.ProvinceCity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void testSelectIf(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
       //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        //        student.setName("dyssl");
        student.setAge(23);
        List<Student> students = dao.selectIf(student);
        students.forEach(stu-> System.out.println("学生："+stu));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectWhere(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("dyssl");
        student.setAge(23);
        List<Student> students = dao.selectIf(student);
        students.forEach(stu-> System.out.println("学生："+stu));
        //3.关闭SqlSesession对象
        session.close();
    }

    @Test
    public void testFor(){
        List<Integer> idlist = new ArrayList<>();
        idlist.add(1001);
        idlist.add(1002);
        idlist.add(1003);
        //查询id在idlist中的student
        StringBuffer sql = new StringBuffer("");
        sql.append("select * from student where id in ");
        //使用循环，把List数据追加到sql字符串
        sql.append("(");
        for(int i=0;i< idlist.size();i++){
            Integer item = idlist.get(i);
            sql.append(item);
            sql.append(",");
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        System.out.println("sql:"+sql);
    }

    @Test
    public void testSelectForeachOne(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Integer> idlist = new ArrayList<>();
//        idlist.add(1001);
//        idlist.add(1002);
//        idlist.add(1003);
//        idlist = null;
        List<Student> students = dao.selectForeachOne(idlist);
        students.forEach(stu-> System.out.println("学生："+stu));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectForeachTwo(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students1 = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setId(1001);
        Student stu2 = new Student();
        stu2.setId(1002);
        students1.add(stu1);
        students1.add(stu2);
        List<Student> students2 = dao.selectForeachTwo(students1);
        students2.forEach(stu-> System.out.println("学生："+stu));
        //3.关闭SqlSesession对象
        session.close();
    }
    @Test
    public void testSelectAllStudents(){
        //1.获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        PageHelper.startPage(1,2);
        List<Student> students = dao.selectAllStudents();
        students.forEach(stu-> System.out.println("学生："+stu));
        //3.关闭SqlSesession对象
        session.close();
    }
}
