package com.labs.lab2phase1.controller;

import com.labs.lab2phase1.entity.Student;
import com.labs.lab2phase1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @PostMapping
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "Student added successfully";
    }


    @GetMapping("/{id}")
    public Student getStudentById (@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> gatAllStudents (){
        return studentService.getAllStudents();
    }


    @DeleteMapping("/{id}")
    public String deleteStudent (@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

}
