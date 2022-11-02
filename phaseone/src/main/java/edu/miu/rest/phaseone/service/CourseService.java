package edu.miu.rest.phaseone.service;

import edu.miu.rest.phaseone.entity.Course;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
public interface CourseService {
    Course save(Course c);

    Course update(Long id, Course c);

    Boolean deleteById(Long id);

    Course findById(Long id);

    List<Course> findAll();
}
