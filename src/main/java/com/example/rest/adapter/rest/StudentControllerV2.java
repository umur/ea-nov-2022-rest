package com.example.rest.adapter.rest;

import com.example.rest.adapter.rest.dto.StudentDTO;
import com.example.rest.entity.Student;
import com.example.rest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student/v2")
public class StudentControllerV2  {

    private final StudentService studentService;

    public StudentControllerV2(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.getAll().stream().map(toStudentDTO()).collect(Collectors.toList());
    }

    @GetMapping("/filter")
    public List<StudentDTO> filterByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major).stream().map(toStudentDTO()).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable String id) {
        StudentDTO studentById = toStudentDTO().apply(studentService.getStudentById(id));
        System.out.println("this is course from post request " +  studentById);
        System.out.println(studentService.getAll());
        return studentById;
    }

    @PostMapping
    public void create(@RequestBody StudentDTO studentDTO) throws Exception {
        studentService.create(toStudent().apply(studentDTO));
        System.out.println(studentService.getAll());
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = toStudentDTO().apply(studentService.update(id, toStudent().apply(studentDTO)));
        System.out.println(studentService.getAll());
        return updatedStudent;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
        System.out.println(studentService.getAll());
    }


    private Function<Student, StudentDTO> toStudentDTO() {
        return s -> new StudentDTO(s.getFirstName() + " " + s.getLastName(), s.getEmail());
    }


    private Function<StudentDTO, Student> toStudent() {
        return s ->  {
            String fullName = s.getFullName();
            String[] s1 = fullName.split(" ");
            return new Student(s1[0], s1[1], s.getEmail());
        };
    }

}
