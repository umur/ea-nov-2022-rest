package com.labs.lab2phase1.controller;

import com.labs.lab2phase1.entity.Course;
import com.labs.lab2phase1.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students/courses")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("/{studentid}/{courseid}")
    public String assignCourse(@PathVariable int studentid ,@PathVariable int courseid){
        return studentCourseService.assignCourse(studentid,courseid);
    }

    @GetMapping("/{studentid}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentid){

        return studentCourseService.getCoursesByStudentId(studentid);
    }

}
