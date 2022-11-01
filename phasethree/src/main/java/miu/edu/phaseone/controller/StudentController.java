package miu.edu.phaseone.controller;

import miu.edu.phaseone.dto.CourseDTO;
import miu.edu.phaseone.dto.StudentDTO;
import miu.edu.phaseone.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping()
    public List<StudentDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public StudentDTO create(@RequestBody StudentDTO student) {
        return service.save(student);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO student) {
        student.setId(id);
        return service.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOne(id);
    }

    @GetMapping("/get-students-by-major/{major}")
    public List<StudentDTO> getStudentsByMajor(@PathVariable String major) {
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/get-courses-by-student-id/{id}")
    public List<CourseDTO> getStudentsByMajor(@PathVariable Long id) {
        return service.getCoursesByStudentId(id);
    }
}
