package com.example.restfulphase3.controller;


import com.example.restfulphase3.dto.CourseDTO;
import com.example.restfulphase3.dto.StudentDTO;
import com.example.restfulphase3.service.CourseService;
import com.example.restfulphase3.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3/students")
public class StudentController extends CrudController<StudentDTO,StudentService> {

    public final CourseService courseService;
    public final ModelMapper mapper;

    public StudentController(StudentService service, CourseService courseService, ModelMapper mapper) {
        super(service);
        this.courseService = courseService;
        this.mapper = mapper;
    }


    @Override
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        var result = service.getAll().stream().map( data -> {
            var dto = mapper.map(data,StudentDTO.class);
            dto.setCoursesTaken(courseService.getAll().stream()
                    .filter( course -> data.getCoursesTaken().contains(course.getId()))
                    .map( course -> mapper.map(course, CourseDTO.class))
                    .toList());
            return dto;
        }).toList();
        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> get(@PathVariable String id) {

        Optional<StudentDTO> result = service.get(id).map( data -> {
            var dto = mapper.map(data,StudentDTO.class);
            dto.setCoursesTaken(courseService.getAll().stream()
                    .filter( course -> data.getCoursesTaken().contains(course.getId()))
                    .map( course -> mapper.map(course, CourseDTO.class))
                    .toList());
            return dto;
        });

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody StudentDTO data) {
        if (service.create(data.toEntity())){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody StudentDTO data) {
        if (service.update(data.toEntity())) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<StudentDTO>> getStudentsByMajor(@RequestParam String major){
        var result = service.getStudentsByMajor(major).stream().map( data -> {
            var dto = mapper.map(data,StudentDTO.class);;
            dto.setCoursesTaken(courseService.getAll().stream()
                    .filter( course -> data.getCoursesTaken().contains(course.getId()))
                    .map( course -> mapper.map(course, CourseDTO.class))
                    .toList());
            return dto;
        }).toList();
        return ResponseEntity.status(result.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.FOUND).body(result);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudentId(@PathVariable String id){
        var result = service.getCoursesByStudentId(id).stream()
                .map(courseId -> courseService.get(courseId)
                        .map(data -> mapper.map(data, CourseDTO.class))
                        .get())
                .toList();
        return ResponseEntity.status(result.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.FOUND).body(result);
    }
}