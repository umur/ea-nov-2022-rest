package com.example.EA.Lab2.Service;

import com.example.EA.Lab2.Entity.Course;
import com.example.EA.Lab2.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student save(Student body);
    Student update(Integer Id, Student body);
    Student findOne(Integer Id);
    void delete(Integer Id);
    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Integer Id);

    }

