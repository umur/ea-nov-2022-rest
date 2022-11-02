package com.example.lab2.repository;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();
    static private List<Course> coursesTaken = new ArrayList<>();


    static {
        coursesTaken.add(new Course(1, "Intro to Java", "CSC 101"));
        students.add(new Student(1, "John", "Doe","jDeo@gmail.com", "Computer Science", 3.5, coursesTaken));

        coursesTaken.add(new Course(2, "Advanced Java", "CSC 102"));
        students.add(new Student(2, "Jane", "Kim","jkim@gmail.com", "Computer Science", 3.8,
                coursesTaken.stream().filter(course -> course.getId() == 2).toList()
        ));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {

        return  students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(int id) {
        students.stream()
                .filter(student -> student.getId() == id)
                .forEach(student -> students.remove(student));
    }

    public void updateStudent(Student student) {
        students.stream()
                .filter(student1 -> student1.getId() == student.getId())
                .forEach(student1 -> {
                    student1.setFirstName(student.getFirstName());
                    student1.setLastName(student.getLastName());
                    student1.setEmail(student.getEmail());
                    student1.setMajor(student.getMajor());
                    student1.setGpa(student.getGpa());
                    student1.setCoursesTaken(student.getCoursesTaken());
                });
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElse(null)
                .getCoursesTaken();
    }
}
