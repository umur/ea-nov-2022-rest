package miu.edu.phaseone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.phaseone.model.Course;

@Data
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private String code;

    public Course toEntity() {
        return new Course(
                this.getId(),
                this.getCode(),
                this.getName()
        );
    }
}
