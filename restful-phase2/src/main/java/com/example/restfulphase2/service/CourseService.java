package com.example.restfulphase2.service;

import com.example.restfulphase2.dto.CourseDTO;
import com.example.restfulphase2.entity.Course;
import com.example.restfulphase2.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService extends CrudService<Course,CourseRepository>{

    public CourseService(CourseRepository repository) {
        super(repository);
    }

}
