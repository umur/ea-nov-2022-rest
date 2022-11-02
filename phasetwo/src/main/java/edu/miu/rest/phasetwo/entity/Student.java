package edu.miu.rest.phasetwo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;

    private List<Course> courses;
}
