package com.example.assignment2.DTO;

import com.example.assignment2.model.Course;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class StudentDto {
    @Id
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    double gpa;
    String coursesTaken;
    @ManyToOne
    private Course course;
}
