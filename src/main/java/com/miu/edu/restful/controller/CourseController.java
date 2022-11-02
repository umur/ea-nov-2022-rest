package com.miu.edu.restful.controller;

import com.miu.edu.restful.entity.Course;
import com.miu.edu.restful.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Object getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/filter")
    public Object getCoursesByStudentId(@RequestParam(value = "studentId", defaultValue = "0") int studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/filter/{id}")
    public Object getCourseById(@PathVariable int id) {
        return courseService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody Course course)  {
        courseService.updateCourse(course);
    }

    @PostMapping
    public void add(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        courseService.removeById(id);
    }
}
