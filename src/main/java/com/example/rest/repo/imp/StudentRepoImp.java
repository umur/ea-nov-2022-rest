package com.example.rest.repo.imp;

import com.example.rest.entity.Course;
import com.example.rest.entity.Student;
import com.example.rest.repo.StudentRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentRepoImp implements StudentRepo {
    public static List<Student> students = new ArrayList<>();
    static {
        Course c1 = new Course(1, "DBMS", "D255");
        Course c2 = new Course(2, "WAP", "W276");
        Course c3 = new Course(13, "EA", "EAWQ12");
        Course c4 = new Course(11, "ML", "ML542");
        Student s1 = new Student(1, "muhannad", "mugh", "m@g.com", "IT", 4.00);
        Student s2 = new Student(2, "ahmad", "ismal", "a@g.com", "IT", 4.00);
        Student s3 = new Student(3, "bara", "bata", "b@g.com", "MA", 4.00);
        s1.addCourse(c1,c2);
        s2.addCourse(c1,c3);
        s3.addCourse(c1,c2,c3, c4);
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public List<Student> getAll() {
        return students;
    }

    public Student getStudentById(String id) {
        return students.stream().filter(p -> Integer.valueOf(p.getId()).toString().equals(id)).findFirst().get();
    }

    public void create(Student student) throws Exception {
        Set<Integer> studentsSet = students.stream().map(Student::getId).collect(Collectors.toSet());

        if (studentsSet.contains(student.getId())) throw new Exception("student Id already exists");

        students.add(student);
    }

    public Student update(String id, Student student){
        Student student1 = students.stream().filter(p -> Integer.valueOf(p.getId()).toString().equals(id)).findFirst().orElse(null);
        int newId = student.getId();
        String fName = student.getFirstName();
        String lName = student.getLastName();
        String email = student.getEmail();
        String major = student.getMajor();
        double gpa = student.getGPA();
        List<Course> courses = student.getCourses();

        student1.setId(newId);
        student1.setFirstName(fName);
        student1.setLastName(lName);
        student1.setGPA(gpa);
        student1.setEmail(email);
        student1.setMajor(major);
        student1.setCourses(courses);
        return  student1;
    }

    public void delete(String id) {
        Student target = students.stream().filter(p -> Integer.valueOf(p.getId()).toString().equals(id)).findFirst().orElse(null);
        students.remove(target);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }


}
