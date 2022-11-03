package com.example.lab2.rest.service;

import com.example.lab2.rest.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    List<Course> getCoursesByStudentId(int studentId);

    void addCourse(Course course);

    void deleteCourse(int courseId);

    void updateCourse(Course course, int id);
}
