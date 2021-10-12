package com.a20da10.service.ejb;

import javax.ejb.Remote;

@Remote
public interface AccountServiceRemote {
    public Boolean InstructorAuthentication(String email,String password);
    public Integer getInstructorIdByEmail(String email);
}
