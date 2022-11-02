package miu.edu.ealab2restphase1.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String gpa;

    private List<Course> courseTaken;
    private boolean isDeleted;

    private Student(){
        this.courseTaken = new ArrayList<>();
    }

    public void addCourse(Course course){
        courseTaken.add(course);
    }
}
