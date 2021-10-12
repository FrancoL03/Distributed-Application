package com.a20da10.dao.spring;

import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.Entity.spring.StudentEntity;

import java.util.List;

public interface CourseDao {
    public void addCourse(CourseEntity courseEntity);
    public CourseEntity getCourseEntity(Integer courseId);
    public List<StudentEntity> getAllStudentOfCourse(Integer courseId);
    public void addStudentsToCourse(StudentEntity studentEntity,CourseEntity courseEntity);

}
