package com.example.rest.adapter.rest;

import com.example.rest.adapter.rest.dto.CourseDTO;
import com.example.rest.entity.Course;
import com.example.rest.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course/v2")
public class CourseControllerV2 {
    private final CourseService courseService;

    public CourseControllerV2(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAll() {
        return courseService
                .getAll().
                stream()
                .map(toCourseDTO())
                .collect(Collectors.toList());
    }

    @GetMapping("/filter")
    public List<CourseDTO> filterByStudentId(@RequestParam String id) {
        return courseService
                .getCoursesByStudentId(id)
                .stream()
                .map(toCourseDTO())
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable String id) {
        CourseDTO courseById = toCourseDTO().apply(courseService.getCourseById(id));
        System.out.println("this is course from post request " +  courseById);
        System.out.println(courseService.getAll());
        return courseById;
    }

    @PostMapping
    public void create(@RequestBody CourseDTO courseDTO) {
        courseService.create(toCourse().apply(courseDTO));
        System.out.println(courseService.getAll());
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable String id, @RequestBody CourseDTO courseDTO) {
        Course course = toCourse().apply(courseDTO);
        CourseDTO updatedCourse = toCourseDTO().apply(courseService.update(id, course));
        System.out.println(courseService.getAll());
        return updatedCourse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        courseService.delete(id);
        System.out.println(courseService.getAll());
    }


    private Function<Course, CourseDTO> toCourseDTO() {
        return c -> new CourseDTO(c.getName());
    }

    private Function<CourseDTO, Course> toCourse() {
        return c -> new Course(c.getName());
    }

}
