package com.example.lab2.service;

import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAll(){
        return repository.getAll();
    }

    public void add(Student s){
        repository.add(s);
    }

    public Student getOne(Integer id){
        return repository.one(id);
    }

    public void update(Integer id, Student s){
        repository.update(id,s);
    }

    public void  delete(Integer id){
        repository.delete(id);
    }

}
