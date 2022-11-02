package com.example.restfulapi.Controller;

import com.example.restfulapi.Entity.Course;
import com.example.restfulapi.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }
    @PostMapping
    public void addNew(@RequestBody Course course){
        courseService.add(course);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Course course){
        courseService.update(id, course);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }
}
