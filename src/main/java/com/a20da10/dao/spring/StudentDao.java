package com.a20da10.dao.spring;

import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.Entity.spring.StudentEntity;

import java.util.List;

public interface StudentDao {
    //1.Create
    public void addStudent(StudentEntity studentEntity);
    //2.Read
    public StudentEntity getStudentEntity(Integer studentId);
    public StudentEntity getStudentEntityByEmail(String email);
    public List<StudentEntity> getAllStudents();
    //3.Update
    public void updateStudent(StudentEntity studentEntity);
    //4.Delete
    public void deleteStudent(Integer studentId);
    //5.High level operation
    public void subscribeCourse(StudentEntity studentEntity,CourseEntity courseEntity);

}
