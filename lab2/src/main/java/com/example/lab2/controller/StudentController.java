package com.example.lab2.controller;

import com.example.lab2.entity.Student;
import com.example.lab2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @PostMapping
    public String add(@RequestBody Student student) {
        studentService.add(student);
        return "Saved successfully.";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Student student) {
        studentService.update(id, student);
        return "Updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "Deleted successfully.";
    }
}
