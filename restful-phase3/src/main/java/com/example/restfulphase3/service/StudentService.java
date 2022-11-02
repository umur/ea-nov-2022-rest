package com.example.restfulphase3.service;

import com.example.restfulphase3.entity.Student;
import com.example.restfulphase3.repository.CourseRepository;
import com.example.restfulphase3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService extends CrudService<Student,StudentRepository>{


    public StudentService(StudentRepository repository, CourseRepository courseRepository) {
        super(repository);
    }

    public List<Student> getStudentsByMajor(String major){
        return repository.getStudentsByMajor(major);
    }

    public List<String> getCoursesByStudentId(String id){
        return repository.getCoursesByStudentId(id);
    }
}
