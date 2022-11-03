package com.example.Restful.repositories;

import com.example.Restful.entities.Course;
import com.example.Restful.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private static List<Student> students = new ArrayList<>();
    static {
        var c1 = new Course(1, "EA", "CS544");
        var c2 = new Course(2, "WAP", "CS422");
        var c3 = new Course(3, "MPP", "CS410");
        var s1 = new Student(1, "Nehemiah", "Tefera",
                "ne@miu.edu", "MSCS", 4.0f, new ArrayList<>(Arrays.asList(c1, c2, c3)));
        var s2 = new Student(2, "Ruth", "Tefera",
                "rt@miu.edu", "MSCS", 3.0f, new ArrayList<>(Arrays.asList(c1, c2)));
        students.add(s1);
        students.add(s2);
    }

    public List<Student> getAll() {
        return students;
    }

    public void create(Student student) {
        students.add(student);
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Student student, int id) {
        students = students.stream()
                .map(s -> {
                    if (s.getId() == 0) {
                        s = student;
                    }
                    return s;
                }).collect(Collectors.toList());
    }

    public void deleteById(int id) {
        students = students.stream()
                .filter(s -> s.getId() != id)
                .collect(Collectors.toList());
    }

    public void deleteByEntity(Student student) {
        students = students.stream()
                .filter(s -> !s.equals(student))
                .collect(Collectors.toList());
    }

    public void addCourse(int id, Course course) {
        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .get();
        if (student != null) {
            List<Course> courses = student.getCoursesTaken();
            courses.add(course);
            student.setCoursesTaken(courses);
        }
    }

}
