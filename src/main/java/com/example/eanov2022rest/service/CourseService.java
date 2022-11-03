package com.example.eanov2022rest.service;

import com.example.eanov2022rest.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();

    void createCourse (Course course);

    void updateCourse (Integer id,String name,String code);

    void deleteCourse (Integer id);

    List<Course> getCoursesByStudentId (Integer id);

    Course getById (Integer id);
}
