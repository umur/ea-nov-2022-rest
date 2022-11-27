package com.labs.lab2phase1.service.serviceimp;

import com.labs.lab2phase1.entity.Course;
import com.labs.lab2phase1.repository.CourseRepo;
import com.labs.lab2phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public void addCourse(Course course) {
        courseRepo.addCourse(course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    @Override
    public void deleteCourse(int id) {
           courseRepo.deleteCourse(id);
    }
}
