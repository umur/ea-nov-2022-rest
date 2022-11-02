package com.example.lab2.controller;

import com.example.lab2.entity.course.Course;
import com.example.lab2.service.courseServiceImpl.CourseServiceImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseServiceImplementation courseServiceImplementation;


    public CourseController(CourseServiceImplementation courseServiceImplementation) {
        this.courseServiceImplementation = courseServiceImplementation;
    }

    @GetMapping()
    public List<Course> getAllCourses(){
        return  courseServiceImplementation.getAllCourse();

    }

    @PostMapping()
    public void getAllCourses(@RequestBody Course course){
        System.out.println(course);
        courseServiceImplementation.addCourse(course);

    }

    @GetMapping("/{id}")
    public Course getAllCourses(@PathVariable Integer id){
        return  courseServiceImplementation.getOneCourse(id);

    }


}
