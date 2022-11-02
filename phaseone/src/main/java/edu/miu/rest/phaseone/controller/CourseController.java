package edu.miu.rest.phaseone.controller;

import edu.miu.rest.phaseone.entity.Course;
import edu.miu.rest.phaseone.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return courseService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.findAll();
    }
}
