package edu.miu.rest.phaseone.service.impl;

import edu.miu.rest.phaseone.entity.Course;
import edu.miu.rest.phaseone.repository.CourseRepository;
import edu.miu.rest.phaseone.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course save(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course update(Long id, Course c) {
        return courseRepository.update(id, c);
    }

    @Override
    public Boolean deleteById(Long id) {
        return courseRepository.deleteById(id);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
