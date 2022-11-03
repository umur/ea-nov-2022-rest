package miu.edu.ea_day2.controllers;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day2.models.Course;
import miu.edu.ea_day2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public void save(@RequestBody Course course){
        courseService.save(course);
    }
    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }
    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course course) {
       courseService.update(id,course);
    }



}
