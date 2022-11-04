package com.example.lab2.controller;

import com.example.lab2.model.dto.CourseDTO;
import com.example.lab2.service.ICourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@RestController
public class CourseController {
    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getCourse(){
        return courseService.getCourse();
    }

    @PostMapping
    public void addCourse(@RequestBody CourseDTO course){
        courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody CourseDTO course){
        courseService.updateCourse(id, course);
    }
}
