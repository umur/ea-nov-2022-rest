package com.example.EA.Lab2.Entity;

//Use n-tier software architecture model.

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;

    @OneToMany
     List<Course> coursesTaken;

}
