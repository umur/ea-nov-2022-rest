package com.example.rest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "course")
public class Course {
//    @Id
    private int id;
    @NonNull
    private String name;
    private String code;

}
