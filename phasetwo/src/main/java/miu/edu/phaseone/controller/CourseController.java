package miu.edu.phaseone.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.phaseone.dto.CourseDTO;
import miu.edu.phaseone.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @GetMapping()
    public List<CourseDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public CourseDTO create(@RequestBody CourseDTO course) {
        return service.save(course);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO course) {
        course.setId(id);
        return service.save(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOne(id);
    }
}
