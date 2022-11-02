package edu.miu.rest.phaseone.controller;

import edu.miu.rest.phaseone.entity.Course;
import edu.miu.rest.phaseone.entity.Student;
import edu.miu.rest.phaseone.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }
}
