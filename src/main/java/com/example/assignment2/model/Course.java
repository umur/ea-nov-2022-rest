package com.example.assignment2.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data // getter and setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String code;
    @ManyToMany(mappedBy = "course")
    private List<Student> students;
}
