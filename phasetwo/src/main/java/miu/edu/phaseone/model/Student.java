package miu.edu.phaseone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.phaseone.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<Course> coursesTaken;

    public StudentDTO toDTO() {
        return new StudentDTO(
                this.getId(),
                this.getFirstName(),
                this.getLastName(),
                this.getEmail(),
                this.getMajor(),
                this.getGpa(),
                this.getCoursesTaken().stream().map(Course::toDTO).collect(Collectors.toList())
        );
    }
}
