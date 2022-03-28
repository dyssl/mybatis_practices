package com.dyssl.dao.impl;

import com.dyssl.dao.StudentDao;
import com.dyssl.domain.Student;
import com.dyssl.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectById(int id) {
        SqlSession session = MyBatisUtil.getSqlSession();
        String sqlId = "com.dyssl.dao.StudentDao.selectStudentById";
        Student student = session.selectOne(sqlId,id);
        session.close();
        return student;
    }

    @Override
    public List<Student> selectStudents() {
        SqlSession session = MyBatisUtil.getSqlSession();
        String sqlid = "com.dyssl.dao.StudentDao.selectStudents";
        List<Student> students = session.selectList(sqlid);
        session.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MyBatisUtil.getSqlSession();
        String sqlid = "com.dyssl.dao.StudentDao.insertStudent";
        int number = session.insert(sqlid,student);
        session.commit();
        session.close();
        return number;
    }
}
