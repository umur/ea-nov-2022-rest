package com.example.restfulphase2.controller;

import com.example.restfulphase2.dto.CourseDTO;
import com.example.restfulphase2.entity.Course;
import com.example.restfulphase2.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v2/courses")
public class CourseController extends CrudController<CourseDTO,CourseService> {

    public CourseController(CourseService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll() {
        var result = service.getAll().stream().map(CourseDTO::fromEntity).toList();
        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> get(@PathVariable String id) {

        var data = service.get(id).map(CourseDTO::fromEntity);

        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody CourseDTO data) {
        if (service.create(data.toEntity())){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody CourseDTO data) {
        if (service.update(data.toEntity())) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
