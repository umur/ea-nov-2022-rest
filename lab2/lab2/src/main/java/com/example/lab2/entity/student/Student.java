package com.example.lab2.entity.student;

import com.example.lab2.entity.course.Course;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
    private  Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<Course> courses;

}
