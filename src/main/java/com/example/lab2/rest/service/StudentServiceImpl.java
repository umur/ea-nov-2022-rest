package com.example.lab2.rest.service;

import com.example.lab2.rest.model.Student;
import com.example.lab2.rest.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return this.studentRepository.getAll();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return this.studentRepository.getStudentsByMajor(major);
    }

    @Override
    public void addStudent(Student student) {
        this.studentRepository.addStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        this.studentRepository.deleteStudent(studentId);
    }

    @Override
    public void updateStudent(Student student, int id) {
        this.studentRepository.updateStudent(student, id);
    }
}
