package miu.edu.ea_day2.controllers;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day2.models.Course;
import miu.edu.ea_day2.models.Student;
import miu.edu.ea_day2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    public final StudentService studentService;

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }


    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentByMajor(@PathVariable String major){
        return studentService.getStudentByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.update(id,student);
    }
}
