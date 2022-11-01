package miu.edu.phaseone.repository;

import miu.edu.phaseone.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    private static Long randomId() {
        return (long) (1 + (Math.random() * (1000000 - 1)));
    }
    public List<Course> findAll() {
        return courses;
    }

    public Course save(Course course) {
        Optional<Course> optional = findOne(course.getId());
        if (optional.isPresent()) {
            int index = courses.indexOf(optional.get());
            courses.get(index).setCode(course.getCode());
            courses.get(index).setName(course.getName());
        } else {
            course.setId(randomId());
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
