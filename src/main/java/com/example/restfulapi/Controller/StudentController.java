package com.example.restfulapi.Controller;

import com.example.restfulapi.Entity.Course;
import com.example.restfulapi.Entity.Student;
import com.example.restfulapi.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @PostMapping
    public void addNew(@RequestBody Student student){
        studentService.add(student);
    }
    @PutMapping
    public void update(@PathVariable Integer id, @RequestBody Student student){
        studentService.update(id, student);
    }
    @DeleteMapping
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }
    @GetMapping("/{id}/course")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }
    @PostMapping("/{studentId}/{courseId}")
    public void addStudentInCourse(@PathVariable int studentId, @PathVariable int courseId){

    }
}
