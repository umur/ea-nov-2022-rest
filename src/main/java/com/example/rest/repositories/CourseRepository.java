package com.example.rest.repositories;

import com.example.rest.entities.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseRepository {
    private static List<Course> courses;

    static {
        courses = new ArrayList<>();
        var c1 = new Course();
        c1.setName("Fundamental Programming Practice");
        c1.setCode("FPP-22");
        courses.add(c1);
    }

    public Course save(Course course) {
        var isExist = courses.stream().noneMatch(c -> c.getId() == course.getId());
        if (isExist) {
            courses.add(course);
        } else {
            return null;
        }
        return course;
    }

    public Course update(int id, Course co) {
        Course tempCourse = courses.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Course not found!!"));
        tempCourse.setCode(co.getCode());
        tempCourse.setName(co.getName());
        return tempCourse;
    }

    public String delete(int id) {
        var isExist = courses.stream().noneMatch(c -> c.getId() == id);
        if (!isExist) {
            courses.stream()
                    .filter(c -> Math.toIntExact(c.getId()) == id).toList()
                    .forEach(c -> courses.remove(Math.toIntExact(c.getId())));
        } else {
            return "Course not found!!!";
        }
        return "Course deleted successfully";
    }

    public Course getById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course does not exists"));
    }

    public List<Course> getAll() {
        return new ArrayList<>(courses);
    }
}
