package com.example.rest.services.impl;

import com.example.rest.entities.Course;
import com.example.rest.repositories.CourseRepository;
import com.example.rest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepository.getById(id);
    }

    @Override
    public Course update(int id, Course course) {
        return courseRepository.update(id, course);
    }

    @Override
    public String delete(int id) {
        return courseRepository.delete(id);
    }
}
