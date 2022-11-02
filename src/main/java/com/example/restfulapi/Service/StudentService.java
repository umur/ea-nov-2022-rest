package com.example.restfulapi.Service;

import com.example.restfulapi.Entity.Course;
import com.example.restfulapi.Entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    List<Student> getAll();
    void update(Integer id, Student student);
    void delete(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
    void addStudentInCourse(int studentId, int courseId);
}
