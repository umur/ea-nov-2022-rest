package com.example.lab2.rest.service;

import com.example.lab2.rest.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    List<Student> getStudentsByMajor(String major);
    void addStudent(Student student);
    void deleteStudent(int studentId);
    void updateStudent(Student student, int id);
}
