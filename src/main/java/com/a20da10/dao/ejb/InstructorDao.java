package com.a20da10.dao.ejb;

import com.a20da10.Entity.ejb.EJBInstructorEntity;
import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.Entity.spring.CourseTypeEnum;

import java.util.List;

public interface InstructorDao {
    public void create(EJBInstructorEntity entity);
    public void updateById(int id, String firstName, String lasttName, String email);
    public List<EJBInstructorEntity> getByName(String firsName, String lastName);
    public EJBInstructorEntity getById(int id);
    public EJBInstructorEntity getByEmail(String email);
    public List<EJBInstructorEntity> getAll();
    public void deleteById(int id);
    public List<CourseEntity> findCoursesByInsId(int insId);
    public void updateCourseInfo(int courseId, String name, int instructorId, CourseTypeEnum type);
    public void addNewCourse(String name, int instructorId, CourseTypeEnum type);
    public void deleteCourse(int courseId);
    public void initEntityManager();
    public int TestInt();
}
