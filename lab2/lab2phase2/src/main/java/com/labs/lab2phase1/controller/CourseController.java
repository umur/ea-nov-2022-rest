package com.labs.lab2phase1.controller;

import com.labs.lab2phase1.entity.Course;
import com.labs.lab2phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public String addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return "course added succefully";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
        return "course deleted successfully";
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }


}
