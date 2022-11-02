package com.example.lab2.controller;

import com.example.lab2.entity.student.Student;
import com.example.lab2.service.courseServiceImpl.CourseServiceImplementation;
import com.example.lab2.service.studentPackageImpl.StudentServiceImplementation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentServiceImplementation studentServiceImplementation;
    private final CourseServiceImplementation courseServiceImplementation;

    public StudentController(StudentServiceImplementation studentServiceImplementation, CourseServiceImplementation courseServiceImplementation) {
        this.studentServiceImplementation = studentServiceImplementation;
        this.courseServiceImplementation = courseServiceImplementation;
    }

     @GetMapping()
     public List<Student> getAllStudents(){
        return studentServiceImplementation.getAllStudent();
     }

}
