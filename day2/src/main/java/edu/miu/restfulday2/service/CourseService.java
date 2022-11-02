package edu.miu.restfulday2.service;

import edu.miu.restfulday2.entity.Course;
import edu.miu.restfulday2.entity.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO save(CourseDTO course);

    List<CourseDTO> getAll();

    CourseDTO update(CourseDTO course);

    void delete(Integer id);
}
