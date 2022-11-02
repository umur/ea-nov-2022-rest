package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;
import com.example.lab2.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudent(){
        return studentRepo.getAll();
    }
    public void addStudent(Student student){
        studentRepo.addStudent(student);
    }
    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }
    public void updateStudent(int id, Student student){
        studentRepo.updateStudent(id, student);
    }
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentsByMajor(major);
    }
    public List<Course> getCoursesByStudentId(int studentId){
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
