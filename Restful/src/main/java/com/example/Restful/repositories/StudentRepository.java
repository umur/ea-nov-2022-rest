package com.example.Restful.repositories;

import com.example.Restful.entities.Course;
import com.example.Restful.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    private static List<Student> students;
    static {
        var c1 = new Course(1, "EA", "CS544");
        var c2 = new Course(2, "WAP", "CS422");
        var c3 = new Course(3, "MPP", "CS410");
        var s1 = new Student(1, "Nehemiah", "Tefera",
                "ne@miu.edu", "MSCS", 4.0f, new ArrayList<>(Arrays.asList(c1, c2, c3)));
        var s2 = new Student(1, "Ruth", "Tefera",
                "rt@miu.edu", "MSCS", 3.0f, new ArrayList<>(Arrays.asList(c1, c2)));
        students.add(s1);
        students.add(s2);
    }
}
