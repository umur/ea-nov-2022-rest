package com.example.assignment2.controller;

import com.example.assignment2.DTO.StudentDto;
import com.example.assignment2.model.Student;
import com.example.assignment2.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@Controller
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping
    public List<Student> getAll(){
        return studentServices.findAll();
    }

    @GetMapping("/major/{major}")
    @ResponseBody
    public List<Student> getByMajor(@PathVariable String major) {
        return studentServices.findStudentByMajor(major);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Student getById(@PathVariable int id) {
        return studentServices.findById(id);
    }
}
