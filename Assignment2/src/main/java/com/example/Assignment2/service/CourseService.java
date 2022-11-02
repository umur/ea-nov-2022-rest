package com.example.Assignment2.service;

import com.example.Assignment2.Entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAll();
    public void delete(int courseId) ;
    public void update(int courseID, Course course);
    public void add(Course course);

}
