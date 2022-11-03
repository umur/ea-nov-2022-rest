package com.example.rest.controllers;

import com.example.rest.entities.Course;
import com.example.rest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.create(course), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<?> getAll() {
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Course course) {
        return new ResponseEntity<>(courseService.update(id, course), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(courseService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable("id") int id) {
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }
}
