package com.ea.api.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String  firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
}
