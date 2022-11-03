package com.example.lab2.rest.service;

import com.example.lab2.rest.model.Course;
import com.example.lab2.rest.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseRepository.getAll();
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return this.courseRepository.getStudentsByMajor(studentId);
    }

    @Override
    public void addCourse(Course course) {
        this.courseRepository.addCourse(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        this.courseRepository.deleteCourse(courseId);
    }

    @Override
    public void updateCourse(Course course, int id) {
        this.courseRepository.updateCourse(course, id);
    }
}
