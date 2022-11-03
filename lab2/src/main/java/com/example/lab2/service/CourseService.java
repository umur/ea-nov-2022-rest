package com.example.lab2.service;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;

import java.util.List;

public interface CourseService {

    Course findById(int id);

    List<Course> getAll();

    List<Course> getCoursesByStudentId(int studentId);

    void add(Course c);

    void update(int id, Course s);

    void delete(int id);
}
