package com.example.assignment2.services;

import com.example.assignment2.DTO.CourseDto;
import com.example.assignment2.DTO.StudentDto;
import com.example.assignment2.model.Course;
import com.example.assignment2.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServices {
    List<Student> findAll();

    Student findById(int id);


    void save(Student p);

    void delete(int id);

    void update(int id, Student p);


    List<Student> findStudentByMajor(String major);

}
