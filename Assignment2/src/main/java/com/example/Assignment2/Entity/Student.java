package com.example.Assignment2.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    int id;
    String firstName;
    String  lastName, email, major;
    double gpa;
}
