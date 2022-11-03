package lab2.restful.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    private String id,
    firstName,
    lastName,
    email,
    major;
    private double gpa;
    private List<Course> coursesTaken;
}
