package miu.edu.ealab2restphase1.entity;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String name;
    private String code;
    private boolean isDeleted;
}
