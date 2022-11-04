package com.example.rest.service.imp1;

import com.example.rest.entity.Course;
import com.example.rest.repo.CourseRepo;
import com.example.rest.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImp implements CourseService {
    private final CourseRepo courseRepo;

    public CourseServiceImp(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public Course getCourseById(String id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public void create(Course p) {
        courseRepo.create(p);
    }

    @Override
    public Course update(String id, Course p) {
        return courseRepo.update(id, p);
    }

    @Override
    public void delete(String id) {
        courseRepo.delete(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(String id) {
        return courseRepo.getCoursesByStudentId(id);
    }
}
