package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.dto.CourseDTO;
import com.example.lab2.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<CourseDTO> getCourse(){
        List<Course> courses = courseRepo.getAll();
        List<CourseDTO> coursesDTO = new ArrayList<>();
        for (Course course: courses) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(course.getName());
            courseDTO.setId(course.getId());
            coursesDTO.add(courseDTO);
        }
        return coursesDTO;
    }
    @Override
    public void addCourse(CourseDTO courseDTO){
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setId(courseDTO.getId());
        course.setCode("001");
        courseRepo.addCourse(course);
    }
    @Override
    public void deleteCourse(int id){
        courseRepo.deleteCourse(id);
    }
    @Override
    public void updateCourse(int id, CourseDTO courseDTO){
        Course course = courseRepo.getCourseById(id);
        course.setName(courseDTO.getName());
        course.setId(courseDTO.getId());
        courseRepo.updateCourse(id, course);
    }
}
