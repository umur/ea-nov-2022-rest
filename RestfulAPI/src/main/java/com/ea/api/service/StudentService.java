package com.ea.api.service;

import com.ea.api.entity.Course;
import com.ea.api.entity.Student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudent();
    Student createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
     List<Course> getCoursesByStudentId(int studentId);
    List<Student> getStudentsByMajor(String major);

}
