package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {

        return courseRepo.getCourseById(id);
    }

    @Override
    public void addCourse(Course course) {
        courseRepo.addCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepo.deleteCourse(id);

    }

    @Override
    public void updateCourse(Course course) {
        courseRepo.updateCourse(course);
    }
}
