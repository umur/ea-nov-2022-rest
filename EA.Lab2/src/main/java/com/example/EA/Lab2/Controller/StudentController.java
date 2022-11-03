package com.example.EA.Lab2.Controller;

import com.example.EA.Lab2.Entity.Course;
import com.example.EA.Lab2.Entity.Student;
import com.example.EA.Lab2.Service.CourseService;
import com.example.EA.Lab2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudents(){
        return studentService.findAll();
    };
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody Student body){
        return studentService.save(body);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Integer Id, @RequestBody Student body){
        return studentService.update(Id, body);
    }
    @GetMapping("/{id}")
    public Student findStudent(@PathVariable Integer Id){
        return studentService.findOne(Id);
    }
    @DeleteMapping("/id")
    public void delete(@PathVariable Integer Id){
        studentService.delete(Id);
    };
    @GetMapping("/{major}")
    public List<Student> filterByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses/{id}")
    public List<Course> getCoursesByStudentId(Integer Id){
        return studentService.getCoursesByStudentId(Id);
    }
}
