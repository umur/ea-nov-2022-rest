package com.example.Assignment2.controller;

import com.example.Assignment2.Entity.Student;
import com.example.Assignment2.Entity.StudentCourses;
import com.example.Assignment2.service.Imp.StudentImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
@RestController
public class studentController {

    @Autowired
    StudentImp stuServ;

    @GetMapping("getAll")
    public List<Student> getAll(){
        return stuServ.getAll();
    }

    @GetMapping("studentCourses")
    public List<StudentCourses> ggetStudentCourses(int studentId){
        return stuServ.getStudentCourses(studentId);
    }

    @GetMapping("getByMajor")
    public List<Student> getStudentByMajor(String major) {
        return stuServ.getStudentByMajor(major);
    }


    @DeleteMapping("delete")
    public void delete(@RequestParam int studentId){
        stuServ.delete(studentId);
    }

    @PostMapping("add")
    public void add(Student student){
        stuServ.add(student);
    }

    @PutMapping("update")
    public void update(Student student , int studentId){
        stuServ.update(studentId, student);
    }




}
