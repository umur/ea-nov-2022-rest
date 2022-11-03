package com.example.rest.services;

import com.example.rest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    Course create(Course course);

    List<Course> getAll();

    Course getById(int id);

    Course update(int id, Course course);

    String delete(int id);
}
