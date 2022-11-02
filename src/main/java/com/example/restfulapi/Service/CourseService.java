package com.example.restfulapi.Service;

import com.example.restfulapi.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    void add(Course course);
    List<Course> getAll();
    void update(Integer id, Course course);
    void delete(int id);
}
