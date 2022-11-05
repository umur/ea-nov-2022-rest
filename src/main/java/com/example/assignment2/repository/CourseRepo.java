package com.example.assignment2.repository;

import com.example.assignment2.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course,Integer> {
    Course findByCode(String code);
}
