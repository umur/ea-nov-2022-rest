package com.example.eanov2022rest.controller;

import com.example.eanov2022rest.entity.Course;
import com.example.eanov2022rest.entity.Student;
import com.example.eanov2022rest.service.CourseService;
import com.example.eanov2022rest.service.StudentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List <Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourseById(@PathVariable("id") Integer id){
        return courseService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Course course ){
        courseService.createCourse(course);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String code) {
        courseService.updateCourse (id,name,code);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        courseService.deleteCourse(id);
    }

}
