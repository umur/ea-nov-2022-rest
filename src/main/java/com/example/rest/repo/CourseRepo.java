package com.example.rest.repo;

import com.example.rest.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface CourseRepo {
    public List<Course> getAll();
    public Course getCourseById(String id);
    public void create(Course p);
    public Course update(String id, Course prod);
    public void delete(String id);
    public List<Course> getCoursesByStudentId(String id);
}
