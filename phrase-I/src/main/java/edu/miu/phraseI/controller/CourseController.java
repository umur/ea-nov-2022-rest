package edu.miu.phraseI.controller;

import edu.miu.phraseI.entity.Course;
import edu.miu.phraseI.repo.CourseRepo;
import edu.miu.phraseI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;


    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping
    public void  save(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("{/id}")
    public Course getById(@PathVariable Integer id){
        return courseService.getById(id);
    }

    @GetMapping
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Course course){
        courseService.update(id,course);
    }



}
