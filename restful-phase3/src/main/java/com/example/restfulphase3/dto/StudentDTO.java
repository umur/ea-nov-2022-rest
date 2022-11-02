package com.example.restfulphase3.dto;

import com.example.restfulphase3.entity.Course;
import com.example.restfulphase3.entity.Identifiable;
import com.example.restfulphase3.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class StudentDTO implements Identifiable {

    String id;
    String firstName;
    String lastName;
    String email;
    String major;
    String gpa;
    List<CourseDTO> coursesTaken;

    public Student toEntity(){
        return new Student(id,firstName,lastName,email,major,gpa,coursesTaken.stream().map(data -> data.getId()).toList());
    }
}
