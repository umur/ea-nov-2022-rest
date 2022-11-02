package com.miu.edu.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data // @getter, @setter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken = new ArrayList<>();

    public Student(int id, String firstName, String lastName, String email, String major, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
    }

    public void addCoursesTaken(Course cource) {
        this.coursesTaken.add(cource);
    }

}
