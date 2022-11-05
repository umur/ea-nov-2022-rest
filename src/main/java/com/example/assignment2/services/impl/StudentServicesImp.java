package com.example.assignment2.services.impl;

import com.example.assignment2.DTO.CourseDto;
import com.example.assignment2.DTO.StudentDto;
import com.example.assignment2.model.Course;
import com.example.assignment2.model.Student;
import com.example.assignment2.repository.StudentRepo;
import com.example.assignment2.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServicesImp implements StudentServices {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }


    @Override
    public void save(Student p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Student p) {

    }

    @Override
    public List<Student> findStudentByMajor(String major) {
        return studentRepo.findStudentByMajor(major);
    }


}
