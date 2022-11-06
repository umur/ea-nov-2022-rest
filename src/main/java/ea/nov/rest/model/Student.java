package ea.nov.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int id;
   private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    List<Course> coursesTaken;

}
