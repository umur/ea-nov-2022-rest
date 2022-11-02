package com.example.restfulphase3.dto;

import com.example.restfulphase3.entity.Course;
import com.example.restfulphase3.entity.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class CourseDTO implements Identifiable{

    String id;
    String name;
    String code;


    public Course toEntity(){
        return new Course(id,name,code);
    }

}