package com.example.restfulphase2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Student implements Identifiable {

    String id;
    String firstName;
    String lastName;
    String email;
    String major;
    String gpa;
    List<String> coursesTaken;


    public void addCourse(String course){
        coursesTaken.add(course);
    }
}
