package edu.miu.phraseI.controller;

import edu.miu.phraseI.entity.Course;
import edu.miu.phraseI.entity.Student;
import edu.miu.phraseI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping
    public List<Student> findAll(){
       return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id){
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.delete(id);
    }


    @GetMapping("/filter")
    public List<Student> getStudentByMajor(@RequestParam String major){
       return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Integer id){
        return studentService.getCoursesByStudentId(id);
    }

}
