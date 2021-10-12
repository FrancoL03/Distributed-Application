package com.a20da10.service.ejb;

import com.a20da10.Entity.ejb.EJBInstructorEntity;
import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.dao.ejb.InstructorDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@WebService
@Stateless(name = "InstructorGenServiceImpl")
public class InstructorGenServiceImpl implements InstructorGenServiceLocal, InstructorGenServiceRemote{

    int testInt = 0;
    @Inject
    private InstructorDao dao;

    @Override
    public List<EJBInstructorEntity> getInstructorByName(String firsName, String lastName) {
        return dao.getByName(firsName, lastName);
    }

    @Override
    public EJBInstructorEntity getInstructorByInsId(int insId) {
        return dao.getById(insId);
    }

    @Override
    public List<EJBInstructorEntity> getAllInstructors() {
        return dao.getAll();
    }

    @Override
    public List<CourseEntity> getCoursesByInsId(int insId) {
        return dao.findCoursesByInsId(insId);
    }

    public int statelessIncrementTestInt(){
        testInt++;
        return testInt;
    }

}
