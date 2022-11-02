package com.example.rest.services;

import com.example.rest.entities.Course;
import com.example.rest.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student create(Student student);

    List<Student> getAll();

    Student getById(int id);

    Student update(int id, Student student);

    String delete(int id);

    List<Student> getStudentByMajor(String major);

    List<Course> getCoursesByStudentId(int id);
}
