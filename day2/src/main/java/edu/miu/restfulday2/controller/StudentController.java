package edu.miu.restfulday2.controller;

import edu.miu.restfulday2.entity.Student;
import edu.miu.restfulday2.entity.dto.StudentDTO;
import edu.miu.restfulday2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //get
    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.getAll();
    }

    //post
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO student){
        return studentService.save(student);
    }

    //update
    @PutMapping
    public StudentDTO update(@RequestBody StudentDTO student){
        return studentService.update(student);
    }


    //delete
    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Integer id){
        return studentService.delete(id);
    }
}
