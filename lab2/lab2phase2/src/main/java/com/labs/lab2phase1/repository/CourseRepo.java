package com.labs.lab2phase1.repository;

import com.labs.lab2phase1.entity.Course;
import com.labs.lab2phase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    public List<Course> listOfCourses=new ArrayList<>();

    public void addCourse(Course course){
        listOfCourses.add(course);
    }


    public Course getCourseById (int id){
        for (Course c: listOfCourses) {
            if(c.getId()==id) return c;
        }
        return null;
    }

    public List<Course> getAllCourses(){
        return listOfCourses;
    }

    public void deleteCourse(int id){
        List<Course> temp=listOfCourses.stream().filter(c->c.getId()!=id).toList();
        listOfCourses=temp;
    }
}
