package com.example.lab2.service.impl;

import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentRepo;
import com.example.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getAll().stream()
                .filter(e -> e.getMajor().contains(major))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Student s) {
        studentRepo.add(s);
    }

    @Override
    public void update(int id, Student s) {
        studentRepo.update(id, s);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }
}
