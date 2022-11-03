package com.example.eanov2022rest.controller;

import com.example.eanov2022rest.entity.Course;
import com.example.eanov2022rest.entity.Student;
import com.example.eanov2022rest.service.CourseService;
import com.example.eanov2022rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private  final CourseService courseService;

    @GetMapping
    public List <Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable("id") Integer id){
        return studentService.getById(id);

    }

    @PostMapping
    public void create(@RequestBody Student student){
         studentService.createStudent(student);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id,
                          @RequestParam(required = false) String email,
                          @RequestParam(required = false) String major) {
         studentService.updateStudent (id,email,major);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);

    }

    @GetMapping(path = "/search")
    public List<Student> getStudentsByMajor(@RequestParam("major") String major){
       return studentService.getStudentsByMajor(major);
    }

    @GetMapping(path = "/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable("id") Integer id){
        return courseService.getCoursesByStudentId(id);

    }

}
