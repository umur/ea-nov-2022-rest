package miu.edu.phaseone.controller;

import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    CourseService service;

    @GetMapping()
    public List<Course> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public Course create(@RequestBody Course course) {
        return service.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return service.save(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOne(id);
    }
}
