package com.example.lab2.service.impl;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.repository.CourseRepo;
import com.example.lab2.repository.StudentRepo;
import com.example.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepo courseRepo;

    private StudentRepo studentRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, StudentRepo studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
          return studentRepo.getAll().stream()
                .filter(e -> e.getId() == studentId)
                .map(e -> e.getCourses())
                .findFirst()
                .get();
    }

    @Override
    public Course findById(int id) {
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public void add(Course c) {
        courseRepo.add(c);
    }

    @Override
    public void update(int id, Course c) {
        courseRepo.update(id, c);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }
}
