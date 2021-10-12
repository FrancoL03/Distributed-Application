package com.a20da10.service.ejb;

import com.a20da10.Entity.ejb.EJBInstructorEntity;
import com.a20da10.Entity.spring.CourseEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface InstructorGenServiceLocal {
    public List<EJBInstructorEntity> getInstructorByName(String firsName, String lastName);
    public EJBInstructorEntity getInstructorByInsId(int insId);
    public List<EJBInstructorEntity> getAllInstructors();
    public List<CourseEntity> getCoursesByInsId (int insId);
    public int statelessIncrementTestInt();
}
