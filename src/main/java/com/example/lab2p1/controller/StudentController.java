package com.example.lab2p1.controller;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.entity.Student;
import com.example.lab2p1.exception.NotFoundException;
import com.example.lab2p1.response.ResponseMessage;
import com.example.lab2p1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseMessage delete(@PathVariable int id) throws Exception {
        try {
            studentService.deleteStudentById(id);
            return new ResponseMessage("Deleted");
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) throws Exception {
        try {
            return studentService.updateStudent(id, student);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) throws Exception {
        try {
            return studentService.getStudentById(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudent(@PathVariable int id) throws Exception {
        try {
            return studentService.getCoursesByStudentId(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }
}
