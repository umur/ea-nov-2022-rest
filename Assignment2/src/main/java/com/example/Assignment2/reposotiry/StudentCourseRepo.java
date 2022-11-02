package com.example.Assignment2.reposotiry;

import com.example.Assignment2.Entity.StudentCourses;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentCourseRepo {

    static List<StudentCourses> scl = new ArrayList<>();

    static {
        StudentCourses sc1 = new StudentCourses(1, 1);
        StudentCourses sc2 = new StudentCourses(1, 2);
        StudentCourses sc3 = new StudentCourses(1, 3);
        StudentCourses sc4 = new StudentCourses(2, 1);
        StudentCourses sc5 = new StudentCourses(3, 1);
        StudentCourses sc6 = new StudentCourses(3, 2);
        scl.add(sc1);
        scl.add(sc2);
        scl.add(sc3);
        scl.add(sc4);
        scl.add(sc5);
        scl.add(sc6);

    }

    public List<StudentCourses> getCoursesByStudentId(int studentId) {
        return scl.stream().filter(x -> x.getStudentID() == studentId).collect(Collectors.toList());
    }


}
