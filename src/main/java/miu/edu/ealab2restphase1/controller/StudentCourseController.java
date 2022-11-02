package miu.edu.ealab2restphase1.controller;

import miu.edu.ealab2restphase1.entity.Course;
import miu.edu.ealab2restphase1.entity.Student;
import miu.edu.ealab2restphase1.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phase1/students/courses")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("/{studentId}/{courseId}/assign")
    public void assignCourse(@PathVariable int studentId,@PathVariable int courseId){
        try{
            studentCourseService.assignCourse(studentId,courseId);
        }
        catch (Exception ex){
            throw new RuntimeException();
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<Course>>  getAllCourses(@PathVariable int studentId){
        return ResponseEntity.status(HttpStatus.OK).body(studentCourseService.getCourseByStudentId(studentId));
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentCourseService.getStudentByMajor(major);
    }
}
