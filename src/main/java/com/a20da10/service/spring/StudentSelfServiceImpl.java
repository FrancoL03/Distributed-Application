package com.a20da10.service.spring;

import com.a20da10.Entity.spring.StudentEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StudentSelfServiceImpl implements StudentSelfService {

    private int StudentId;
    @Override
    public StudentEntity getBasicInfo() {

        return null;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

}
