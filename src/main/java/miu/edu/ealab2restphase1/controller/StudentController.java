package miu.edu.ealab2restphase1.controller;

import miu.edu.ealab2restphase1.entity.Student;
import miu.edu.ealab2restphase1.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phase1/students")
public class StudentController {
    @Autowired
    private GenService<Student> studentGenService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(studentGenService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(studentGenService.find(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentGenService.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentGenService.delete(id);
    }
}
