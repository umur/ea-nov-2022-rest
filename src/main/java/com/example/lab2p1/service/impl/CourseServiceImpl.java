package com.example.lab2p1.service.impl;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.repository.CourseRepository;
import com.example.lab2p1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository repository;
    @Override
    public List<Course> getAll() {
        return repository.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return repository.getCourseById(id);
    }

    @Override
    public void deleteCourseById(int id) {
        repository.deleteCourseById(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        return repository.updateCourse(id, course);
    }

}
