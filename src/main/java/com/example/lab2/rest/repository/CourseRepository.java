package com.example.lab2.rest.repository;

import com.example.lab2.rest.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    static List<Course> courses = new ArrayList<>();

    static {
        Course c1 = new Course(1, "EA", "544");
        Course c2 = new Course(2, "WAA", "545");
        Course c3 = new Course(3, "MWA", "550");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public List<Course> getAll(){
        return courses;
    }

    public List<Course> getStudentsByMajor(int studentID){
        return courses.stream().filter( s -> s.getId() == studentID).toList();
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void deleteCourse(int courseId){
        courses = courses.stream().filter(c -> c.getId() != courseId).toList();
    }

    public void updateCourse(Course course, int id){
        Course courseToUpdate = courses.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        int curIndex = courses.indexOf(courseToUpdate);
        courses.set(curIndex, course);
    }
}
