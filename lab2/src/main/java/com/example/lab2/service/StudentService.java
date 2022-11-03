package com.example.lab2.service;

import com.example.lab2.entity.Student;

import java.util.List;

public interface StudentService {

    Student findById(int id);

    List<Student> getAll();

    List<Student> getStudentsByMajor(String major);

    void add(Student s);

    void update(int id, Student s);

    void delete(int id);
}
