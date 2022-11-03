package com.example.ModelMapper.services.impl;

import com.example.ModelMapper.entities.Student;
import com.example.ModelMapper.repositories.StudentRepo;
import com.example.ModelMapper.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void delete(Student student) {
        studentRepo.delete(student);
    }

    @Override
    public List<Student> findStudentByMajor(String major) {
        return studentRepo.findStudentsByMajor(major);
    }
}
