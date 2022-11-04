package com.example.rest.adapter.rest.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {
    @NotNull
    private String name;
}
