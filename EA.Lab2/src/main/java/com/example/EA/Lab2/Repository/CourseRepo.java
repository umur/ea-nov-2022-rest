package com.example.EA.Lab2.Repository;

import com.example.EA.Lab2.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

   // Optional<Course> getCoursesByStudentId(Integer Id);

}
