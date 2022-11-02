package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getCourse(){
        return courseRepo.getAll();
    }
    public void addCourse(Course course){
        courseRepo.addCourse(course);
    }
    public void deleteCourse(int id){
        courseRepo.deleteCourse(id);
    }
    public void updateCourse(int id, Course course){
        courseRepo.updateCourse(id, course);
    }
}
