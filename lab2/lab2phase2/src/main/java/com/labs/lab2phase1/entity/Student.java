package com.labs.lab2phase1.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;

    private List<Course> coursesTaken =new ArrayList<>();

    public void addCourse(Course course){
        coursesTaken.add(course);
    }
}
