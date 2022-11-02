package com.miu.edu.restful.controller;

import com.miu.edu.restful.entity.Student;
import com.miu.edu.restful.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Object getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/filter")
    public Object getStudentsByMajor(@RequestParam(value = "major", defaultValue = "") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/filter/{id}")
    public Object getStudentById(@PathVariable int id) throws Exception {
        return studentService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        studentService.removeById(id);
    }
}
