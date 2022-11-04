package com.example.lab2.service.studentPackageImpl;

import com.example.lab2.entity.student.Student;
import com.example.lab2.repository.StudentRepository;
import com.example.lab2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAllStudent() {
        return null;
    }

    @Override
    public Student getOneStudent(Integer id) {
        return null;
    }

    @Override
    public void addStudent(Student student) {

    }
}
