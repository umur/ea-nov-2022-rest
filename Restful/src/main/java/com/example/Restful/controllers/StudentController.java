package com.example.Restful.controllers;

import com.example.Restful.entities.Student;
import com.example.Restful.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getall() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Student student) {
        studentService.create(student);
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return map;
    }

    @PutMapping("/{id}")
    public Map<String, String> update(@RequestBody Student student, @PathVariable int id) {
        studentService.update(student, id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable int id) {
        studentService.delete(id);
        Map<String, String> map = new HashMap<>();
        map.put("Message", "success");
        return map;
    }

}
