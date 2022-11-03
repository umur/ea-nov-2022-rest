package com.example.Restful.services;

import com.example.Restful.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();
    Student getById(int id);

    void create(Student student);

    void update(Student student, int id);

    void delete(int id);

}
