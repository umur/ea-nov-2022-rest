package com.example.lab2p1.factory;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    public static List<Student> students = new ArrayList<>();
    ;
    public static List<Course> courses = new ArrayList<>();
    ;
    public static int seedStudentId = 0;
    public static int seedCourseId = 0;

    public static int generateStudentId(){
        return ++seedStudentId;
    }

    public static int generateCourseId(){
        return ++seedCourseId;
    }

    static {
        var js = new Course(seedCourseId++, "JavaScript", "JS");
        var jsb = new Course(seedCourseId++, "Java Spring Boot", "JavaSpringBoot");
        var python = new Course(seedCourseId++, "Python", "Python");
        var math = new Course(seedCourseId++, "Math", "Math");
        var crypto = new Course(seedCourseId++, "Crypto", "Crypto");
        courses.addAll(List.of(js, jsb, python, math, crypto));
        students.add(new Student(seedStudentId++, "John", "Last", "sdg@email.com", "CS", 3.9, List.of(js, jsb)));
        students.add(new Student(seedStudentId++, "Mary", "Popping", "sdg@email.com", "Finance", 3.9, List.of(math)));
        students.add(new Student(seedStudentId++, "Dave", "John", "sdfh@email.com", "CS", 3.9, List.of(python, crypto)));
        students.add(new Student(seedStudentId++, "John", "Carter", "sg@email.com", "Finance", 3.9, List.of(crypto, math)));
        students.add(new Student(seedStudentId++, "Joe", "Gold", "asdf@email.com", "CS", 3.9, List.of(python, js)));
    }
}
