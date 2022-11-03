package com.example.lab2p1.service.impl;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.entity.Student;
import com.example.lab2p1.repository.StudentRepository;
import com.example.lab2p1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student add(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return this.studentRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return this.studentRepository.getStudentById(id);
    }

    @Override
    public void deleteStudentById(int id) {
        this.studentRepository.deleteStudentById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return this.studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) throws Exception {
        return this.studentRepository.getCoursesByStudentId(id);
    }

    @Override
    public Student updateStudent(int id, Student student) throws Exception {
        return this.studentRepository.updateStudent(id, student);
    }


}
