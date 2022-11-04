package com.example.rest.repo;

import com.example.rest.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepo {
    public List<Student> getAll();
    public Student getStudentById(String id);
    public void create(Student student) throws Exception;
    public Student update(String id, Student student);
    public void delete(String id);
    public List<Student> getStudentsByMajor(String major);
}
