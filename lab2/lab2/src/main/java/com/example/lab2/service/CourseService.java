package com.example.lab2.service;

import com.example.lab2.entity.course.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getAllCourse();

    public Course getOneCourse(Integer id);

    public void addCourse(Course course);
}
