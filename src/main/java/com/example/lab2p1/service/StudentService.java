package com.example.lab2p1.service;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student add(Student student);

    List<Student> getAll();

    Student getStudentById(int id) throws Exception;

    void deleteStudentById(int id) throws Exception;

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int id) throws Exception;

    Student updateStudent(int id, Student student) throws Exception;
}
