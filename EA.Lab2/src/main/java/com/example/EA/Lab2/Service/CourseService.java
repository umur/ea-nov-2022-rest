package com.example.EA.Lab2.Service;

import com.example.EA.Lab2.Entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course save(Course body);
    Course update(Integer Id, Course body);
    Course findOne(Integer Id);
    void delete(Integer Id);


}
