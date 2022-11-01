package miu.edu.phaseone.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.model.Student;
import miu.edu.phaseone.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping()
    public List<Student> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Student create(@RequestBody Student student) {
        return service.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return service.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOne(id);
    }

    @GetMapping("/get-students-by-major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/get-courses-by-student-id/{id}")
    public List<Course> getStudentsByMajor(@PathVariable Long id) {
        return service.getCoursesByStudentId(id);
    }
}
