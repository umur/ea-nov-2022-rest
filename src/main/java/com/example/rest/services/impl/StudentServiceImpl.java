package com.example.rest.services.impl;

import com.example.rest.entities.Course;
import com.example.rest.entities.Student;
import com.example.rest.repositories.StudentRepository;
import com.example.rest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student update(int id, Student student) {
        return studentRepository.update(id, student);
    }

    @Override
    public String delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentRepository.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }
}
