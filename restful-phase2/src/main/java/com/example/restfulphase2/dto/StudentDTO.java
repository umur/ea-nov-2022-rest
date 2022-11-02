package com.example.restfulphase2.dto;

import com.example.restfulphase2.entity.Course;
import com.example.restfulphase2.entity.Identifiable;
import com.example.restfulphase2.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class StudentDTO implements Identifiable {

    String id;
    String firstName;
    String lastName;
    String email;
    String major;
    String gpa;
    List<Course> coursesTaken;

    public static StudentDTO fromEntity(Student data){
        return new StudentDTO(data.getId(),data.getFirstName(),data.getLastName(),data.getEmail(),data.getGpa(),data.getMajor(),new ArrayList<>());
    }

    public Student toEntity(){
        return new Student(id,firstName,lastName,email,major,gpa,coursesTaken.stream().map(data -> data.getId()).toList());
    }
}
