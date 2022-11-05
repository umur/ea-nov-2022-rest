package com.example.assignment2.DTO;


import com.example.assignment2.model.Student;
import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class CourseDto {
    @Id
    int id;
    String name;
    String code;
    private List<Student> students;
}
