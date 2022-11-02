package edu.miu.rest.phasetwo.controller;

import edu.miu.rest.phasetwo.dtos.CourseDTO;
import edu.miu.rest.phasetwo.dtos.StudentDTO;
import edu.miu.rest.phasetwo.entity.Course;
import edu.miu.rest.phasetwo.entity.Student;
import edu.miu.rest.phasetwo.service.StudentService;
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
    public StudentDTO create(@RequestBody StudentDTO student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/filter")
    public List<StudentDTO> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable Long studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }
}
