package com.example.rest.adapter.rest;

import com.example.rest.entity.Student;
import com.example.rest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v1")
public class StudentControllerV1 {

    private final StudentService studentService;

    public StudentControllerV1(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/filter")
    public List<Student> filterByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        Student studentById = studentService.getStudentById(id);
        System.out.println("this is course from post request " +  studentById);
        System.out.println(studentService.getAll());
        return studentById;
    }

    @PostMapping
    public void create(@RequestBody Student student) throws Exception {
        studentService.create(student);
        System.out.println(studentService.getAll());
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        Student updatedStudent = studentService.update(id, student);
        System.out.println(studentService.getAll());
        return updatedStudent;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
        System.out.println(studentService.getAll());
    }

}
