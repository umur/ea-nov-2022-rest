package edu.miu.rest.phasetwo.service.impl;

import edu.miu.rest.phasetwo.dtos.CourseDTO;
import edu.miu.rest.phasetwo.entity.Course;
import edu.miu.rest.phasetwo.repository.CourseRepository;
import edu.miu.rest.phasetwo.service.CourseService;
import edu.miu.rest.phasetwo.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseDTO save(CourseDTO c) {
        return Utils.entityToDto(courseRepository.save(Utils.dtoToEntity(c, new Course())), c);
    }

    @Override
    public CourseDTO update(Long id, CourseDTO c) {
        return Utils.entityToDto(courseRepository.update(id, Utils.dtoToEntity(c, new Course())), c);
    }

    @Override
    public Boolean deleteById(Long id) {
        return courseRepository.deleteById(id);
    }

    @Override
    public CourseDTO findById(Long id) {
        return  Utils.entityToDto(courseRepository.findById(id), new CourseDTO());
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(x -> Utils.entityToDto(x, new CourseDTO())).collect(Collectors.toList());
    }
}
