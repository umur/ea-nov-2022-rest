package com.example.EA.Lab2.Controller;

import com.example.EA.Lab2.Entity.Course;
import com.example.EA.Lab2.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getCourses(){
        return courseService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course save(@RequestBody Course body){
        return courseService.save(body);
    }
    @PutMapping("/{id}")
    public Course update(@PathVariable Integer Id, @RequestBody Course body){
        return courseService.update(Id, body);
    }
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Integer id){
        return courseService.findOne(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }


    }

