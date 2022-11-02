package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;
import com.example.lab2.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void addStudent(Student student) {

        studentRepo.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {

        studentRepo.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);

    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepo.getAllStudents();
    }

    @Override
    public Student getStudentById(Integer id) {

        return studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {

        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {

        return studentRepo.getCoursesByStudentId(studentId);
    }
}
