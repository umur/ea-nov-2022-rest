package miu.edu.phaseone.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<Course> coursesTaken;
}
