package edu.miu.phraseI.entity;


import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private int id;
    private String name;
    private String code;

}
