package com.example.lab2.repo;

import com.example.lab2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    static {
        var c1 = new Course(1, "EA", "CS544");
        var c2 = new Course(2, "WAA", "CS545");
        var c3 = new Course(3, "MWA", "CS572");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }
    public List<Course> getAll(){
        return courses;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public void deleteCourse(int id){
        courses = courses.stream().filter(s->s.getId() != id).toList();
    }
    public void updateCourse(int id, Course course){
        List<Course> listOfFoundCourses = courses.stream().filter(s -> s.getId() == id).toList();
        if (listOfFoundCourses.size() > 0){
            int i = courses.indexOf(listOfFoundCourses.get(0));
            courses.set(i, course);
        }
    }
    public Course getCourseById(int id){
       return courses.stream().filter(c -> c.getId()== id).toList().get(0);
    }
}
