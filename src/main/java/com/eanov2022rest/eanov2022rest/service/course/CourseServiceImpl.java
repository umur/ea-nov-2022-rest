package com.eanov2022rest.eanov2022rest.service.course;

import com.eanov2022rest.eanov2022rest.entity.Course;
import com.eanov2022rest.eanov2022rest.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public Course add(Course course) {
        return null;
    }

    @Override
    public Course getCourseById(int id) {
        return null;
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }

    @Override
    public void deleteCourseById(int id) {

    }
}
