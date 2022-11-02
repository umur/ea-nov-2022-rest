package com.example.restfulapi.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String major;
    private String gpa;
    private List<Course> coursesTaken;
}
