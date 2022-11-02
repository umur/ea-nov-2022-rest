package com.miu.edu.restful.repository.impl;

import com.miu.edu.restful.data.Data;
import com.miu.edu.restful.entity.Course;
import com.miu.edu.restful.entity.Student;
import com.miu.edu.restful.exception.NotFoundException;
import com.miu.edu.restful.repository.CourseRepository;
import com.miu.edu.restful.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    private List<Course> courses = Data.getCourses();

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getAllStudents().stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .orElse(new Student())
                .getCoursesTaken();
    }

    @Override
    public Course getById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElseThrow(() -> new NotFoundException("Can't find the Course with id " + id));
    }

    @Override
    public void updateCourse(Course udpatedCourse) {
        Optional<Course> course = courses.stream()
                .filter(c -> c.getId() == udpatedCourse.getId())
                .findAny();
        course.ifPresent(c -> {
            c.setCode(udpatedCourse.getCode());
            c.setName(udpatedCourse.getName());
        });
    }

    @Override
    public void addCourse(Course course) {
        course.setId(Data.currentCourseId++);
        courses.add(course);
    }

    @Override
    public void removeById(int id) {
        Optional<Course> course = courses.stream()
                .filter(c->c.getId() == id)
                .findAny();
        course.ifPresent(courses::remove);
    }
}
