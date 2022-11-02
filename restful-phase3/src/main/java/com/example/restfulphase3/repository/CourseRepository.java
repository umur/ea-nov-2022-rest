package com.example.restfulphase3.repository;

import com.example.restfulphase3.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class CourseRepository extends CrudRepository<Course> {

    public CourseRepository(){
        super();
        list = new ArrayList<Course>();
        list.add(new Course("1","EA", "001"));
        list.add(new Course("2","WAA", "002"));
    }
}

