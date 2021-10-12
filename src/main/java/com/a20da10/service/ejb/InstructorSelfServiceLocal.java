package com.a20da10.service.ejb;

import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.Entity.spring.CourseTypeEnum;

import javax.ejb.Local;
import java.util.List;

@Local
public interface InstructorSelfServiceLocal {
    public List<CourseEntity> getCoursesOfMine (int insId);
    public void insertInstructor(String firstName, String lasttName, String email, String password);
    public void updateInstructor(int insId, String firstName, String lasttName, String email);
    public void deleteInstructorByInsId(int insId);
    public void updateCourseInfo(int courseId, String name, int instructorId, CourseTypeEnum type);
    public void addNewCourse(String name, int instructorId, CourseTypeEnum type);
    public void deleteCourse(int courseId);
    public int statefulIncrementTestInt ();
    public void setInsId(int id);
    public int getInsId();
}
