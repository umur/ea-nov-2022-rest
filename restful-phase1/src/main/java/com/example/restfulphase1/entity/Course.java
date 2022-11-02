package com.example.restfulphase1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course implements Identifiable {

    String id;
    String name;
    String code;

}