package com.example.rest.adapter.rest;

import com.example.rest.entity.Course;
import com.example.rest.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/v1")
public class CourseControllerV1 {
    private final CourseService courseService;

    public CourseControllerV1(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/filter")
    public List<Course> filterByStudentId(@RequestParam String id) {
        return courseService.getCoursesByStudentId(id);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) {
        Course courseById = courseService.getCourseById(id);
        System.out.println("this is course from post request " +  courseById);
        System.out.println(courseService.getAll());
        return courseById;
    }

    @PostMapping
    public void create(@RequestBody Course p) {
        courseService.create(p);
        System.out.println(courseService.getAll());
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable String id, @RequestBody Course p) {
        Course updatedCourse = courseService.update(id, p);
        System.out.println(courseService.getAll());
        return updatedCourse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        courseService.delete(id);
        System.out.println(courseService.getAll());
    }

}
