package com.example.Assignment2.controller;

import com.example.Assignment2.Entity.Course;
import com.example.Assignment2.service.Imp.CourseImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("course")
@RestController
public class courseController {

    @Autowired
    CourseImp courseSer;

    @GetMapping("getAll")
    public List<Course> getAll() {
        return courseSer.getAll();
    }

    @DeleteMapping("delete")
    public void delete(int courseId) {
        courseSer.delete(courseId);
    }

    @PutMapping("update")
    public void update(int courseID, Course course) {
        courseSer.update(courseID,course);
    }

    @PostMapping("add")
    public void add(Course course) {
        courseSer.add(course);
    }
}
