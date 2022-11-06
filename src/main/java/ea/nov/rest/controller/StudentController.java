package ea.nov.rest.controller;

import ea.nov.rest.dto.StudentDto;
import ea.nov.rest.model.Course;
import ea.nov.rest.model.Student;
import ea.nov.rest.service.impl.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService = service;
    }

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/major")
    public List<Student> getStudentsByMajor(@RequestParam String major)
    {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses")
    public List<Course> getCoursesByStudentId(@RequestParam int id){
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping(value="/add",consumes = "application/json")
    public void add(@RequestBody Student s){
        studentService.addStudent(s);
    }



    @GetMapping("/getById/{id}")
    public Student getByStudentId(@PathVariable int id)
    {
        return studentService.getByStudentId(id);
    }

    @PostMapping(value="/dto/add",consumes = "application/json")
    public void add(@RequestBody StudentDto studentDto){
        studentService.addStudent(studentDto);
    }

    @GetMapping("/dto/all")
    public List<StudentDto> getAllDto(){
        return studentService.getAllDto();
    }

    @GetMapping("/dto/major")
    public List<StudentDto> getMajorDto(@RequestParam String major){
        return studentService.getStudentsByMajor(major)
                .stream()
                .map(studentService::toDto)
                .collect(Collectors.toList());

    }

    @GetMapping("/dto/getById/{id}")
    public StudentDto getStudentById(@PathVariable int id){
//        System.out.println("Id=> "+ id);
//        System.out.println(studentService.getByStudentId(id));
        return studentService.toDto(studentService.getByStudentId(id));
    }
}
