package com.miu.edu.restful.service.impl;

import com.miu.edu.restful.entity.Student;
import com.miu.edu.restful.repository.StudentRepository;
import com.miu.edu.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major).stream().toList();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    @Override
    public void removeById(int id) {
        studentRepository.removeById(id);
    }
}
