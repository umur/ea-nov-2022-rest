package com.example.rest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<Course> courseTaken;
}
