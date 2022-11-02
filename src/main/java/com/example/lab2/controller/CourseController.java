package com.example.lab2.controller;

import com.example.lab2.entity.Course;
import com.example.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @GetMapping
    public List<Course> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Course getOne(@PathVariable Integer id){
        return service.getOne(id);
    }

    @PostMapping
    public void add(@RequestBody Course c){
        service.add(c);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Course c){
        service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
