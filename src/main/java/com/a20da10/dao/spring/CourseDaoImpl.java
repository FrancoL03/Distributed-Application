package com.a20da10.dao.spring;

import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.Entity.spring.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCourse(CourseEntity courseEntity) {
        if (courseEntity!=null){
            Session session = sessionFactory.getCurrentSession();
            session.save(courseEntity);
        }
    }

    @Override
    public CourseEntity getCourseEntity(Integer courseId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CourseEntity.class,courseId);
    }

    @Override
    public List<StudentEntity> getAllStudentOfCourse(Integer courseId) {
        CourseEntity courseEntity = getCourseEntity(courseId);
        return courseEntity.getStudentEntities();
    }

    @Override
    public void addStudentsToCourse(StudentEntity studentEntity,CourseEntity courseEntity) {

        courseEntity.addStudent(studentEntity);
    }


}
