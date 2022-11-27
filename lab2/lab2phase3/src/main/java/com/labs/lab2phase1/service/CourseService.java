package com.labs.lab2phase1.service;

import com.labs.lab2phase1.entity.Course;
import com.labs.lab2phase1.entity.Student;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);
    Course getCourseById(int id);
    List<Course> getAllCourses();
    void deleteCourse(int id);

}
