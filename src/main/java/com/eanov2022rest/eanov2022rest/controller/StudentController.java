package com.eanov2022rest.eanov2022rest.controller;

import com.eanov2022rest.eanov2022rest.entity.Student;
import com.eanov2022rest.eanov2022rest.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    @GetMapping("/ping")
    public String ping() {
        return "Ping Test";
    }

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudent() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> storeStudent(@RequestBody Student student) {
        studentService.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        System.out.println("HEllO");
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/search/")
    public ResponseEntity<?> getStudentsByMajor(@RequestParam String major) {
        return new ResponseEntity<>(studentService.getStudentsByMajor(major), HttpStatus.OK);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCoursesByStudentId(@PathVariable int id) {
        return new ResponseEntity<>(studentService.getCoursesByStudentId(id), HttpStatus.OK);
    }


}
