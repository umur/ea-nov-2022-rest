package com.example.lab2p1.controller;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.exception.NotFoundException;
import com.example.lab2p1.response.ResponseMessage;
import com.example.lab2p1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/courses")
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        try {
            return courseService.getCourseById(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseMessage deleteCourseById(@PathVariable int id) {
        try {
            courseService.deleteCourseById(id);
            return new ResponseMessage("Deleted course");
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    public Course deleteCourseById(@PathVariable int id, @RequestBody Course course) {
        try {
            return courseService.updateCourse(id, course);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }
}
