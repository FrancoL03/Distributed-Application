package com.a20da10.service.spring;

public interface LoginOutAndRegisterService {
    public Boolean StudentAuthentication(String email,String password);
    public Integer getStudentIdByEmail(String email);
}
