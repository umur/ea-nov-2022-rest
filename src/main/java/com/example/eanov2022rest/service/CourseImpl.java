package com.example.eanov2022rest.service;

import com.example.eanov2022rest.entity.Course;
import com.example.eanov2022rest.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseImpl implements CourseService {
   private final CourseRepo courseRepo;
    @Override
    public List<Course> getAll(){
        return courseRepo.getAll ();
    }

    @Override
    public Course getById (Integer id) {
        return courseRepo.findById(id);
    }

    @Override
    public void createCourse (Course course) {
        courseRepo.create(course);


    }

    @Override
    public void updateCourse (Integer id,String name,String code) {
        courseRepo.update(id,name,code);

    }

    @Override
    public void deleteCourse (Integer id) {
        courseRepo.delete(id);

    }

    @Override
    public List <Course> getCoursesByStudentId (Integer id) {
        return courseRepo.getCoursesByStudentId(id);
    }

}
