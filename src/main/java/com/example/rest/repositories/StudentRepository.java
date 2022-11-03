package com.example.rest.repositories;

import com.example.rest.entities.Course;
import com.example.rest.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static List<Student> students;
    private static List<Course> courses;

    static {
        var s1 = new Student();
        var c1 = new Course();
        students = new ArrayList<>();
        courses = new ArrayList<>();


        c1.setName("Modern Programming Practice Practice");
        c1.setCode("MPP-22");
        courses.add(c1);


        s1.setFirstName("John");
        s1.setLastName("Doe");
        s1.setEmail("john@doe.com");
        s1.setMajor("Computer Science");
        s1.setGpa(4.0);
        s1.setCourseTaken(courses);

        students.add(s1);
    }

    public Student save(Student student) {
        var isExist = students.stream().noneMatch(s -> s.getId() == student.getId());
        if (isExist) {
            students.add(student);
        } else {
            return null;
        }
        return student;
    }

    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    public String delete(int id) {
        var isExist = students.stream().noneMatch(s -> s.getId() == id);
        if (!isExist) {
            students.stream()
                    .filter(s -> s.getId() == id)
                    .toList()
                    .forEach(st -> students.remove(st));
        } else {
            return "Student not found!!!";
        }
        return "Student deleted successfully";
    }

    public Student getById(int id) {
        return students.stream().
                filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found!!!"));
    }

    public Student update(int id, Student student) {
        Student tempStu = students.stream().filter(s -> s.getId() == id).findAny().orElseThrow(() -> new RuntimeException("Student not found!!"));
        tempStu.setFirstName(student.getFirstName());
        tempStu.setLastName(student.getLastName());
        tempStu.setEmail(student.getEmail());
        tempStu.setMajor(student.getMajor());
        tempStu.setGpa(student.getGpa());
        tempStu.setCourseTaken(student.getCourseTaken());
        return tempStu;
    }

    public List<Student> getStudentByMajor(String major) {
        return students.stream()
                .filter(s -> Objects.equals(s.getMajor(), major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream()
                .filter(s -> s.getId() == studentId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Student not found!!"))
                .getCourseTaken();
    }
}
