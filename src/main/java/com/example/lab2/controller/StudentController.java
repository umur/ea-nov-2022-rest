package com.example.lab2.controller;


import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Integer id) {
        return service.getOne(id);
    }

    @GetMapping("/courses/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable Integer id) {
        return service.getCoursesByStudentId(id);
    }

    @PostMapping
    public void add(@RequestBody Student s) {
        service.add(s);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Student s) {
        service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
