package miu.edu.phaseone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.phaseone.model.Student;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<CourseDTO> coursesTaken;

    public Student toEntity() {
        return new Student(
                this.getId(),
                this.getFirstName(),
                this.getLastName(),
                this.getEmail(),
                this.getMajor(),
                this.getGpa(),
                this.getCoursesTaken().stream().map(CourseDTO::toEntity).collect(Collectors.toList())
        );
    }
}
