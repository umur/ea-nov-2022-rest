package miu.edu.ealab2restphase1.controller;

import miu.edu.ealab2restphase1.entity.Course;
import miu.edu.ealab2restphase1.service.GenService;
import miu.edu.ealab2restphase1.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phase1/courses")
public class CourseController {
    @Autowired
    private GenService<Course> courseGenService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(courseGenService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> findCourseById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(courseGenService.find(id));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        courseGenService.save(course);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseGenService.delete(id);
    }
}
