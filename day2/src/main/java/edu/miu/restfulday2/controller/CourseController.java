package edu.miu.restfulday2.controller;

import edu.miu.restfulday2.entity.Course;
import edu.miu.restfulday2.entity.dto.CourseDTO;
import edu.miu.restfulday2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //get
    @GetMapping
    public List<CourseDTO> findAll(){
        return courseService.getAll();
    }

    //post
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.save(course);
    }

    //update
    @PutMapping
    public CourseDTO updateCourse(@RequestBody CourseDTO course){
        return courseService.update(course);
    }

    //delete
    @DeleteMapping("/{id}")
    public boolean deleteCourse(@PathVariable Integer id){
        courseService.delete(id);
        return true;
    }



}
