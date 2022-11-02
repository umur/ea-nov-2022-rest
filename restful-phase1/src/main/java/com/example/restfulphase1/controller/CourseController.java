package com.example.restfulphase1.controller;
import com.example.restfulphase1.entity.Course;
import com.example.restfulphase1.service.CourseService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/courses")
public class CourseController extends CrudController<Course,CourseService> {

    public CourseController(CourseService service) {
        super(service);
    }
}
