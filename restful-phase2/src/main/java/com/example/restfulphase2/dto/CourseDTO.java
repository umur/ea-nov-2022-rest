package com.example.restfulphase2.dto;

import com.example.restfulphase2.entity.Course;
import com.example.restfulphase2.entity.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CourseDTO implements Identifiable{

    String id;
    String name;
    String code;

    public static CourseDTO fromEntity(Course data){
        return new CourseDTO(data.getId(),data.getName(),data.getCode());
    }

    public Course toEntity(){
        return new Course(id,name,code);
    }

}