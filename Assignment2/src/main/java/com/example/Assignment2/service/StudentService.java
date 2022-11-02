package com.example.Assignment2.service;

import com.example.Assignment2.Entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student s);

    void delete(int id);

    void update(int id, Student s);

    List<Student> getAll();
}
