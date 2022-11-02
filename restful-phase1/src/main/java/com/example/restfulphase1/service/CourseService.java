package com.example.restfulphase1.service;

import com.example.restfulphase1.entity.Course;
import com.example.restfulphase1.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends CrudService<Course,CourseRepository>{

    public CourseService(CourseRepository repository) {
        super(repository);
    }
}
