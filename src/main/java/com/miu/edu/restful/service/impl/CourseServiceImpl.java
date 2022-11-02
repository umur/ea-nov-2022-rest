package com.miu.edu.restful.service.impl;

import com.miu.edu.restful.entity.Course;
import com.miu.edu.restful.repository.CourseRepository;
import com.miu.edu.restful.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return courseRepository.getCoursesByStudentId(studentId);
    }

    @Override
    public Course getById(int id) {
        return courseRepository.getById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    @Override
    public void removeById(int id) {
        courseRepository.removeById(id);
    }
}
