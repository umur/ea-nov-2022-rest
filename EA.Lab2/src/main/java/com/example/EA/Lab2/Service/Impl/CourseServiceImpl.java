package com.example.EA.Lab2.Service.Impl;

import com.example.EA.Lab2.Entity.Course;
import com.example.EA.Lab2.Entity.Student;
import com.example.EA.Lab2.Repository.CourseRepo;
import com.example.EA.Lab2.Repository.StudentRepo;
import com.example.EA.Lab2.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentRepo studentRepo;

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    ;
    public Course save(Course body){
        return courseRepo.save(body);
    }
    public Course update(Integer Id, Course body){
        Optional<Course> updating = courseRepo.findById(Id);
        if(updating.isPresent()){
            return courseRepo.save(updating.get());
        }
        return null;
    }

    public Course findOne(Integer Id){
        Optional<Course> found = courseRepo.findById(Id);
        if(found.isPresent()){
            return found.get();
        } return null;
    }
    public void delete(Integer Id){
        courseRepo.deleteById(Id);
    }
}
