package com.eanov2022rest.eanov2022rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String major;
    public double GPA;
    public List<Course> coursesTaken;
}
