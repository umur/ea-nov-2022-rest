package com.example.lab2p1.service;

import com.example.lab2p1.entity.Course;

import java.util.List;

public interface CourseService{
    List<Course> getAll();
    Course getCourseById(int id);
    void deleteCourseById(int id);

    Course saveCourse(Course course);

    Course updateCourse(int id, Course course);
}
