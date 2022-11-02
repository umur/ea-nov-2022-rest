package edu.miu.rest.phasetwo.controller;

import edu.miu.rest.phasetwo.dtos.CourseDTO;
import edu.miu.rest.phasetwo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return courseService.deleteById(id);
    }

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping
    public List<CourseDTO> getAll() {
        return courseService.findAll();
    }
}
