package com.example.rest.controllers;

import com.example.rest.entities.Student;
import com.example.rest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;


    @PostMapping
    ResponseEntity<?> create(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.create(student), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<?> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.update(id, student), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable("id") int id) {
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable int id) {
        return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/filter")
    ResponseEntity<?> getStudentListByMajor(@RequestParam("major") String major) {
        return new ResponseEntity<>(studentService.getStudentByMajor(major), HttpStatus.OK);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCoursesByStudentId(@PathVariable("id") int id) {
        return new ResponseEntity<>(studentService.getCoursesByStudentId(id), HttpStatus.OK);
    }


}
