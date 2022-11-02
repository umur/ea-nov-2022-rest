package com.example.restfulphase2.service;

import com.example.restfulphase2.dto.CourseDTO;
import com.example.restfulphase2.dto.StudentDTO;
import com.example.restfulphase2.entity.Student;
import com.example.restfulphase2.repository.CourseRepository;
import com.example.restfulphase2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
