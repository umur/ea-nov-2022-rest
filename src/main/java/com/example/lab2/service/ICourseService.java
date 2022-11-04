package com.example.lab2.service;

import com.example.lab2.model.dto.CourseDTO;

import java.util.List;

public interface ICourseService {
    List<CourseDTO> getCourse();

    void addCourse(CourseDTO course);

    void deleteCourse(int id);

    void updateCourse(int id, CourseDTO course);
}
