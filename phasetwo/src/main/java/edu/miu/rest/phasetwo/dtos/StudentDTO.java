package edu.miu.rest.phasetwo.dtos;

import edu.miu.rest.phasetwo.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/2/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;

    private List<Course> courses;
}
