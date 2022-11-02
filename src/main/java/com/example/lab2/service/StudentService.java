package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(Integer id);
    void updateStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);

}
