package com.example.lab2.repository;

import com.example.lab2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "Intro to Java", "CSC 101"));
        courses.add(new Course(2, "Advanced Java", "CSC 102"));
        courses.add(new Course(3, "Intro to Python", "CSC 103"));
        courses.add(new Course(4, "Advanced Python", "CSC 104"));
        courses.add(new Course(5, "Intro to C++", "CSC 105"));
        courses.add(new Course(6, "Advanced C++", "CSC 106"));
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void deleteCourse(int id) {
        courses.stream()
                .filter(course -> course.getId() == id)
                .forEach(course -> courses.remove(course));
    }

    public void updateCourse(Course course) {
        courses.stream()
                .filter(course1 -> course1.getId() == course.getId())
                .forEach(course1 -> {
                    course1.setName(course.getName());
                    course1.setCourseCode(course.getCourseCode());
                });
    }



}
