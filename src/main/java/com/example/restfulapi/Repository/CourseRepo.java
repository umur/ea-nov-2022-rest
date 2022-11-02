package com.example.restfulapi.Repository;

import com.example.restfulapi.Entity.Course;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    List<Course> courseList = new ArrayList<>();

    public List<Course> getAll(){
        return courseList;
    }

    public void addNew(Course course){
        courseList.add(course);
    }

    public void delete(int id){
        courseList.remove(courseList.stream().filter(course -> course.getId() == id).toList().get(0));
    }

    public void update(Integer id, Course course){
        Course oldCourse = courseList.stream().filter(course1 -> course1.getId() == id).toList().get(0);
        oldCourse.setCode(course.getCode());
        oldCourse.setName(course.getName());
        addNew(course);
    }

}
