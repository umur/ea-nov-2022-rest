package com.labs.lab2phase1.service;

import com.labs.lab2phase1.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();

    void deleteStudent(int id);
    public List<Student> getStudentsByMajor(String major);
}
