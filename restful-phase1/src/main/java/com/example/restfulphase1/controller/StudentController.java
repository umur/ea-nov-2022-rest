package com.example.restfulphase1.controller;


import com.example.restfulphase1.entity.Course;
import com.example.restfulphase1.entity.Student;
import com.example.restfulphase1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController extends CrudController<Student,StudentService> {

    public StudentController(StudentService service) {
        super(service);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Student>> getStudentsByMajor(@RequestParam String major){
        var result = service.getStudentsByMajor(major);
        return ResponseEntity.status(result.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.FOUND).body(result);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable String id){
        var result = service.getCoursesByStudentId(id);
        return ResponseEntity.status(result.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.FOUND).body(result);
    }
}