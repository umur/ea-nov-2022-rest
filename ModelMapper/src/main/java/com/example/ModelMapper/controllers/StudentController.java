package com.example.ModelMapper.controllers;

import com.example.ModelMapper.entities.Student;
import com.example.ModelMapper.services.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    {
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Student student) {
        studentService.save(student);
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return map;
    }

    @PutMapping
    public Map<String, String> update(@RequestBody Student student) {
        studentService.save(student);
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        studentService.deleteById(id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return map;
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/filter")
    public List<Student> findStudentByMajor(@RequestParam String major) {
        return studentService.findStudentByMajor(major);
    }
}
