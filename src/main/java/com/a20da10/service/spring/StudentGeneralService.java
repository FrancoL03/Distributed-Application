
package com.a20da10.service.spring;

import com.a20da10.Entity.spring.StudentEntity;

import java.util.List;

public interface StudentGeneralService {
    public StudentEntity getSingleStudent(Integer id);
    public List<StudentEntity> getAllStudent();
    public void saveStudent(StudentEntity studentEntity);
    public void updateStudent(StudentEntity studentEntity);
    public void deleteStudent(Integer id);
}