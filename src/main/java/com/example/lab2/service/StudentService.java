package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;
import com.example.lab2.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepo.getAll();
    }
    @Override
    public void addStudent(Student student){
        studentRepo.addStudent(student);
    }
    @Override
    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }
    @Override
    public void updateStudent(int id, Student student){
        studentRepo.updateStudent(id, student);
    }
    @Override
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentsByMajor(major);
    }
    @Override
    public List<Course> getCoursesByStudentId(int studentId){
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
