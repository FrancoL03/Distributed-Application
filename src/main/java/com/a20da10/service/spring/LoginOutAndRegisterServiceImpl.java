package com.a20da10.service.spring;

import com.a20da10.Entity.spring.StudentEntity;
import com.a20da10.dao.spring.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class LoginOutAndRegisterServiceImpl implements LoginOutAndRegisterService {
    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public Boolean StudentAuthentication(String email,String password) {
        StudentEntity studentEntity=studentDao.getStudentEntityByEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
//        String pw = passwordEncoder.encode("test");
        //        System.out.println(passwordEncoder.encode(password));
//        String pw = passwordEncoder.encode("test");
        Boolean result =passwordEncoder.matches(password, studentEntity.getPassword());
        if (result){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    @Transactional
    public Integer getStudentIdByEmail(String email) {
        StudentEntity studentEntity=studentDao.getStudentEntityByEmail(email);
        return studentEntity.getStudentId();
    }

}
