package com.eanov2022rest.eanov2022rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    public int id;
    public String name;
    public String code;
}
