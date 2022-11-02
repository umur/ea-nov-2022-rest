package com.example.restfulphase3.service;

import com.example.restfulphase3.entity.Course;
import com.example.restfulphase3.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends CrudService<Course,CourseRepository>{

    public CourseService(CourseRepository repository) {
        super(repository);
    }

}
