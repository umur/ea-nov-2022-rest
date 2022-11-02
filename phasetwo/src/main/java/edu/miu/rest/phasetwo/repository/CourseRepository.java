package edu.miu.rest.phasetwo.repository;

import edu.miu.rest.phasetwo.entity.Course;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
public interface CourseRepository {

    Course save(Course c);

    Course update(Long id, Course c);

    Boolean deleteById(Long id);

    Course findById(Long id);

    List<Course> findAll();
}
