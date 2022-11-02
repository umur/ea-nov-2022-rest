package com.example.Assignment2.service.Imp;

import com.example.Assignment2.Entity.Course;
import com.example.Assignment2.reposotiry.CourseRepo;
import com.example.Assignment2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImp implements CourseService {

    @Autowired
    CourseRepo crepo;

    public List<Course> getAll() {
        return crepo.getAll();
    }

    public void delete(int courseId) {
        crepo.delete(courseId);
    }

    public void update(int courseID, Course course) {
        crepo.updateCourse(course, courseID);
    }

    public void add(Course course) {
        crepo.add(course);
    }


}
