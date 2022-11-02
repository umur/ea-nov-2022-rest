package com.example.lab2.rest.controller;

import com.example.lab2.rest.model.Course;
import com.example.lab2.rest.service.ICourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return this.courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable("id") int studentId){
        return this.courseService.getCoursesByStudentId(studentId);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){
        this.courseService.addCourse(course);
    }

    @DeleteMapping("/id")
    public void deleteCourse(@RequestParam int id){
        this.courseService.deleteCourse(id);
    }

    @PutMapping("/id")
    public void deleteCourse(@RequestBody Course course, @RequestParam int id){
        this.courseService.updateCourse(course, id);
    }
}
