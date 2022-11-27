package com.labs.lab2phase1.service.serviceimp;

import com.labs.lab2phase1.entity.Student;
import com.labs.lab2phase1.repository.StudentRepo;
import com.labs.lab2phase1.service.StudentService;
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
    public Student getStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }



    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentsByMajor(major);
    }

}
