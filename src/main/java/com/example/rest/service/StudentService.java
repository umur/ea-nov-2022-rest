package com.example.rest.service;

import com.example.rest.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    public List<Student> getAll();
    public Student getStudentById(String id);
    public void create(Student student) throws Exception;
    public Student update(String id, Student student);
    public void delete(String id);
    public List<Student> getStudentsByMajor(String major);
}
