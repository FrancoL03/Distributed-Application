package com.a20da10.SOAP;

import com.a20da10.Entity.ejb.EJBInstructorEntity;
import com.a20da10.dao.ejb.InstructorDaoImpl;
import com.a20da10.service.ejb.Test;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService
@Component
public class Soap { //This class is used to generate wsdl files and SOAP java files

    private Test test = new Test();
    private InstructorDaoImpl instructorDaoImpl = new InstructorDaoImpl();

    public EJBInstructorEntity getById(int id) {
        instructorDaoImpl.initEntityManager();
        return instructorDaoImpl.getById(id);
    }
}
