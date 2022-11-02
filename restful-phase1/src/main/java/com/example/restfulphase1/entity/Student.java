package com.example.restfulphase1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
@Data
@AllArgsConstructor
public class Student implements Identifiable {

    String id;
    String firstName;
    String lastName;
    String email;
    String major;
    String gpa;
    ArrayList<Course> coursesTaken;


    public void addCourse(Course course){
        coursesTaken.add(course);
    }
}
