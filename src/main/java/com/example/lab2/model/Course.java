package com.example.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // getter, setter
public class Course {
    private int id;
    private String name;
    private String code;
}
