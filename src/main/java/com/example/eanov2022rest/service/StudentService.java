package com.example.eanov2022rest.service;

import com.example.eanov2022rest.entity.Student;

import java.util.List;

public interface StudentService {
    void updateStudent (Integer id,String email,String major);

    void deleteStudent (Integer id);

    List<Student> getAll ();

    //Student getStudentById (Integer id);

    void createStudent (Student student);

    List<Student> getStudentsByMajor (String major);

    Student getById (Integer id);
}
