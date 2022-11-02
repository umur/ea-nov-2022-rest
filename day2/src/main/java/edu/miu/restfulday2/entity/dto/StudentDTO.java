package edu.miu.restfulday2.entity.dto;

import edu.miu.restfulday2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;

    private List<Course> courseTaken;
}
