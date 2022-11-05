package com.example.assignment2.controller;

import com.example.assignment2.DTO.CourseDto;
import com.example.assignment2.services.CourseService;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/courses")
@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CourseDto findById(@PathVariable int id){
        return courseService.findById(id);
    }
}
