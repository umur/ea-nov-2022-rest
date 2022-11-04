package com.example.lab2.repository;

import com.example.lab2.entity.course.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    static List<Course> courses=new ArrayList<>();

    static {

        var ea=new Course(1,"EA",544);
        var waa=new Course(2,"WAA",504);
        var mwa=new Course(3,"MWA",543);
        courses.add(ea);
        courses.add(waa);
        courses.add(mwa);

    }


    public List<Course> getAllCourse(){
        return  courses;
    }
    public Course getOneCourse(Integer id){
        return courses.stream().filter(val-> val.getId() == id).collect(Collectors.toList()).get(0);
    }

    public void addCoure(Course course){
        courses.add(course);
    }



}
