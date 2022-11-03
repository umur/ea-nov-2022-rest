package com.example.Restful.services.impl;

import com.example.Restful.entities.Student;
import com.example.Restful.repositories.StudentRepository;
import com.example.Restful.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void create(Student student) {
        studentRepository.create(student);
    }

    @Override
    public void update(Student student, int id) {
        studentRepository.update(student, id);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }


}
