package com.example.restfulphase1.service;

import com.example.restfulphase1.entity.Course;
import com.example.restfulphase1.entity.Student;
import com.example.restfulphase1.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService extends CrudService<Student,StudentRepository>{

    public StudentService(StudentRepository repository) {
        super(repository);
    }

    public List<Student> getStudentsByMajor(String major){
        return repository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(String id){
        return repository.getCoursesByStudentId(id);
    }
}
