package com.eanov2022rest.eanov2022rest.service.course;

import com.eanov2022rest.eanov2022rest.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    public List<Course> getAll();
    public Course add(Course course);
    public Course getCourseById(int id);
    public Course updateCourse(Course course);
    public void deleteCourseById(int id);
}
