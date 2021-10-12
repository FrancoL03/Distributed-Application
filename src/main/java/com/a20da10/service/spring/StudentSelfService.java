package com.a20da10.service.spring;

import com.a20da10.Entity.spring.StudentEntity;

public interface StudentSelfService {
    public StudentEntity getBasicInfo();


    public void setStudentId(int i);

    public int getStudentId();
}
