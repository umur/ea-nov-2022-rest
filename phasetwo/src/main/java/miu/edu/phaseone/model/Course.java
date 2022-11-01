package miu.edu.phaseone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.phaseone.dto.CourseDTO;

@Data
@AllArgsConstructor
public class Course {
    private Long id;
    private String name;
    private String code;

    public CourseDTO toDTO() {
        return new CourseDTO(
                this.getId(),
                this.getCode(),
                this.getName()
        );
    }
}
