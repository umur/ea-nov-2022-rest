package com.example.restfulapi.Service.Impl;

import com.example.restfulapi.Entity.Course;
import com.example.restfulapi.Repository.CourseRepo;
import com.example.restfulapi.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public void add(Course course) {
        courseRepo.addNew(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public void update(Integer id, Course course) {
        courseRepo.update(id, course);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }
}
