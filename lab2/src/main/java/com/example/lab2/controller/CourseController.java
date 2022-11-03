package com.example.lab2.controller;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getStudentById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @GetMapping("/filter")
    public List<Course> getCoursesByStudentId(int studentId)  {
        return courseService.getCoursesByStudentId(studentId);
    }

    @PostMapping
    public String add(@RequestBody Course course) {
        courseService.add(course);
        return "Saved successfully.";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Course course) {
        courseService.update(id, course);
        return "Updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        courseService.delete(id);
        return "Deleted successfully.";
    }
}
