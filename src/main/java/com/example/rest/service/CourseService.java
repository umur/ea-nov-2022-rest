package com.example.rest.service;

import com.example.rest.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    public List<Course> getAll();
    public Course getCourseById(String id);
    public void create(Course p);
    public Course update(String id, Course prod);
    public void delete(String id);
    public List<Course> getCoursesByStudentId(String id);
}
