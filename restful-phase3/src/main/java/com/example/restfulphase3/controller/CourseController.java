package com.example.restfulphase3.controller;

import com.example.restfulphase3.dto.CourseDTO;
import com.example.restfulphase3.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v3/courses")
public class CourseController extends CrudController<CourseDTO,CourseService> {

    public final ModelMapper mapper;

    public CourseController(CourseService service, ModelMapper mapper) {
        super(service);
        this.mapper = mapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll() {
        var result =  service.getAll().stream().map(data -> mapper.map(data, CourseDTO.class)).toList();
        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> get(@PathVariable String id) {

        var result = service.get(id).map(data -> mapper.map(data, CourseDTO.class));

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
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
