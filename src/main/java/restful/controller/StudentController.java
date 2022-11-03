package lab2.restful.controller;

import lab2.restful.models.Course;
import lab2.restful.models.Student;
import lab2.restful.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return this.studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable String id){
        return this.studentService.getStudentById(id);
    }

    @GetMapping("/search")
    public ResponseEntity filterCourses(@RequestParam Map<String, String> reqParam){
        if(reqParam.containsKey("major"))
            return new ResponseEntity(this.studentService.getStudentsByMajor(reqParam.get("major")), HttpStatus.OK);
        else if(reqParam.containsKey("id"))
                return new ResponseEntity(this.studentService.getCoursesByStudentId(reqParam.get("id")), HttpStatus.OK);
        return null;
    }

    @PostMapping
    public String addStudent(@RequestBody Student s){
        boolean success = this.studentService.addStudent(s);
        if(success){
            return "successfully added student";
        }
        else{
            return "unable to add to student";
        }
    }

    @PutMapping("/{id}")
    public String updateStudent(@RequestBody Student s, @PathVariable String id){
        boolean success = this.studentService.updateStudent(s, id);
        if(success){
            return "successfully updated student";
        }
        else{
            return "unable to update to student";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id){
        boolean success = this.studentService.deleteStudentById(id);
        if(success){
            return "successfully deleted student";
        }
        else{
            return "unable to delete to student";
        }
    }


}
