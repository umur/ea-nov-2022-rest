package com.example.lab2.service;

import com.example.lab2.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int id);
    void addCourse(Course course);
    void deleteCourse(int id);
    void updateCourse(Course course);
}
