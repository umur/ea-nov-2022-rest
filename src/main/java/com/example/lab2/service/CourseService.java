package com.example.lab2.service;

import com.example.lab2.entity.Course;
import com.example.lab2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository repository;

    public List<Course> getAll(){
        return repository.getAll();
    }


    public Course getOne(Integer id){
        return repository.one(id);
    }

    public void add(Course c){
        repository.add(c);
    }

    public  void  update(Integer id, Course c){
        repository.update(id, c);
    }

    public void  delete(Integer id){
        repository.delete(id);
    }
}
