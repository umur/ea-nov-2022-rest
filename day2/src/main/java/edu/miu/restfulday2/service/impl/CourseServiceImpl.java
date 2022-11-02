package edu.miu.restfulday2.service.impl;

import edu.miu.restfulday2.entity.Course;
import edu.miu.restfulday2.entity.dto.CourseDTO;
import edu.miu.restfulday2.repo.CourseRepo;
import edu.miu.restfulday2.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDTO save(CourseDTO course) {
        return modelMapper.map(courseRepo.save(modelMapper.map(course, Course.class)), CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getAll() {
        List<Course> courses = courseRepo.getCourseList();
        return courses.stream().map(course ->  modelMapper.map(course, CourseDTO.class) ).collect(Collectors.toList());
    }

    @Override
    public CourseDTO update(CourseDTO course) {
        return modelMapper.map(courseRepo.update(modelMapper.map(course, Course.class)), CourseDTO.class);
    }



    @Override
    public void delete(Integer id) {
        courseRepo.deleteById(id);
    }
}
