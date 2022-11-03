package com.example.lab2p1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<Course> coursesTaken;

    public Student(int id, String firstName, String lastName, String email, String major, Double gpa, List<Course> coursesTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.coursesTaken = coursesTaken;
    }
}
