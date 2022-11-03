package com.example.eanov2022rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String gpa;
    private String code;
    private List <Course> coursesTaken = new ArrayList <> ();

    public Student (Integer id,String firstName,String lastName,String email,String major,String gpa,String code) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.code = code;
    }


}
