package com.example.assignment2.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data // getter and setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    double gpa;
    String coursesTaken;
    @ManyToMany
    private List<Course> course;
}
