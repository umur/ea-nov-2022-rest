package com.example.ModelMapper.services;

import com.example.ModelMapper.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void deleteById(Long id);

    void delete(Student student);

    List<Student> findStudentByMajor(String major);
}
