package com.example.lab2.service.courseServiceImpl;

import com.example.lab2.entity.course.Course;
import com.example.lab2.repository.CourseRepository;
import com.example.lab2.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService {

     private final CourseRepository courseRepository;

    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }
    @Override
    public Course getOneCourse(Integer id) {
        return courseRepository.getOneCourse(id);
    }

    @Override
    public void addCourse(Course course) {
        int count=courseRepository.getAllCourse().size();
        Course c=new Course(count+1,course.getName(),course.getCode());

        courseRepository.addCoure(c);

    }
}
