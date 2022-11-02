package com.example.restfulapi.Service.Impl;

import com.example.restfulapi.Entity.Course;
import com.example.restfulapi.Entity.Student;
import com.example.restfulapi.Repository.StudentRepo;
import com.example.restfulapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void add(Student student) {
        studentRepo.addNew(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public void update(Integer id, Student student) {
        studentRepo.update(id, student);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }

    @Override
    public void addStudentInCourse(int studentId, int courseId) {

    }
}
