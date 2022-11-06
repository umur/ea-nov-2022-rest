package ea.nov.rest.dto;

import ea.nov.rest.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private String firstName;
    private String lastName;
    List<Course> coursesTaken;
}
