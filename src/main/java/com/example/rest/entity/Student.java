package com.example.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
//@Entity
//@Table(name = "student")
public class Student {
//    @Id
//    @NonNull
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double GPA;

    public Student(int id, String firstName, String lastName, String email, String major, double GPA) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.GPA = GPA;
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
//    @OneToMany(cascade = CascadeType.PERSIST)
    List<Course> courses = new ArrayList<>();

    public void addCourse(Course... courses) {
        this.courses.addAll(Arrays.asList(courses));
    }
}
