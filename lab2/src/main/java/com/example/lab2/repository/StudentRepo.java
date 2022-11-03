package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();

    static {

        var stu1 = new Student(10001, "Diptesh", "Shrestha", "diptesh.shrestha@miu.edu", "MSCS", 0, Arrays.asList(CourseRepo.fpp, CourseRepo.mpp));
        var stu2 = new Student(10002, "Bipul", "Ranjitkar", "bipul.ranjitkar@miu.edu", "MSD", 0, Arrays.asList(CourseRepo.fpp, CourseRepo.mpp));
        var stu3 = new Student(10003, "Santosh", "Manandhar", "santosh.manandhar@miu.edu", "MSCS", 0, Arrays.asList(CourseRepo.fpp, CourseRepo.mpp));
        var stu4 = new Student(10004, "Sunit", "Bajracharya", "sunit.bajracharya@miu.edu", "MSD", 0, Arrays.asList(CourseRepo.fpp, CourseRepo.mpp));
        var stu5 = new Student(10005, "Abhay", "Rawal", "abhay.rawal@miu.edu", "MSCS", 0, Arrays.asList(CourseRepo.fpp, CourseRepo.mpp));

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
    }

    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .get();
    }

    public List<Student> getAll() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public void update(int id, Student s) {
        Student studentToUpdate = findById(id);

        int index = students.indexOf(studentToUpdate);
        students.set(index, s);
    }

    public void delete(int id) {
        Student studentToDelete = findById(id);

        int index = students.indexOf(studentToDelete);
        students.remove(index);
    }
}
