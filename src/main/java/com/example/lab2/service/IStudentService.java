package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(int id);

    void updateStudent(int id, Student student);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
}
