package com.example.lab2p1.repository;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.exception.NotFoundException;
import com.example.lab2p1.factory.Factory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> repository;

    public CourseRepository() {
        this.repository = Factory.courses;
    }

    public Course save(Course course) {
        var created = new Course(Factory.generateCourseId(), course.getName(), course.getCode());
        this.repository.add(created);
        return created;
    }

    public List<Course> getAllCourses() {
        return this.repository;
    }

    public Course getCourseById(int id) throws NotFoundException {
        return this.repository.stream().filter(c -> c.getId() == id).findFirst().orElseThrow(() -> new NotFoundException("Not Found Course"));
    }

    public void deleteCourseById(int id) {
        var course = this.getCourseById(id);
        this.repository.remove(course);
    }

    public Course updateCourse(int id, Course course) {
        var c = this.getCourseById(id);
        if (course.getName() != null) {
            c.setName(course.getName());
        }
        if (course.getCode() != null) {
            c.setCode(course.getCode());
        }

        return c;
    }
}
