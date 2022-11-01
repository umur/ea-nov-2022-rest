package miu.edu.phaseone.repository;

import miu.edu.phaseone.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public List<Course> findAll() {
        return courses;
    }

    public Course save(Course course) {
        if (findOne(course.getId()).isPresent()) {
            Optional<Course> optional = findOne(course.getId());
           int index = courses.indexOf(optional.get());
           courses.get(index).setCode(course.getCode());
            courses.get(index).setName(course.getName());
        } else {
            courses.add(course);
        }
        return course;
    }

    public Optional<Course> findOne(Long id) {
        return courses.stream().filter(course -> course.getId().equals(id)).findAny();
    }

    public void deleteOne(Long id) {
        this.courses = this.courses.stream().filter(course -> !course.getId().equals(id)).collect(Collectors.toList());
    }
}
