package com.example.lab2.service;

import com.example.lab2.entity.student.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();

    public Student getOneStudent(Integer id);

    public void addStudent(Student student);
}
