package com.example.lab2.rest.controller;

import com.example.lab2.rest.model.Student;
import com.example.lab2.rest.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return this.studentService.getAll();
    }

    @GetMapping("/filterByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return this.studentService.getStudentsByMajor(major);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        this.studentService.addStudent(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student, @RequestParam int id){
        this.studentService.updateStudent(student, id);
    }

    @DeleteMapping
    public void deleteStudent(@RequestParam int id){
        this.studentService.deleteStudent(id);
    }
}
