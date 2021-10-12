package com.a20da10.service.spring;


import com.a20da10.Entity.spring.StudentEntity;
import com.a20da10.dao.spring.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("prototype")
public class StudentGeneralServiceImpl implements StudentGeneralService {
    @Autowired
    private StudentDao studentDao;
    @Override
    @Transactional
    public StudentEntity getSingleStudent(Integer id) {

        return studentDao.getStudentEntity(id);
    }

    @Override
    @Transactional
    public List<StudentEntity> getAllStudent() {
        return studentDao.getAllStudents();
    }

    @Override
    @Transactional
    public void saveStudent(StudentEntity studentEntity) {
        //because here we use the auto checking duplicating function of spring s]]
        studentDao.updateStudent(studentEntity);
    }

    @Override
    @Transactional
    public void updateStudent(StudentEntity studentEntity) {
        studentDao.updateStudent(studentEntity);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        studentDao.deleteStudent(id);
    }

}
