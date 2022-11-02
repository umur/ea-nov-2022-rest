package com.example.lab2.repo;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();
    static {
        List<Course> list1 = new ArrayList<>();
        List<Course> list2 = new ArrayList<>();
        List<Course> list3 = new ArrayList<>();
        list1.add(CourseRepo.courses.get(0));
        list1.add(CourseRepo.courses.get(1));
        list2.add(CourseRepo.courses.get(2));
        list2.add(CourseRepo.courses.get(1));
        list3.add(CourseRepo.courses.get(2));
        var s1 = new Student(1, "John", "Lennon", "john.l@miu.edu", "", 3.8, list1);
        var s2 = new Student(2, "Alica", "Richard", "alica.r@miu.edu", "", 3.9, list2);
        var s3 = new Student(3, "Ann", "Marie", "ann.m@miu.edu", "", 4.0, list3);
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }
    public List<Student> getAll(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void deleteStudent(int id){
        students = students.stream().filter(s->s.getId() != id).toList();
    }
    public void updateStudent(int id, Student student){
        List<Student> students1 = students.stream().filter(s -> s.getId() == id).toList();
        if (students1.size() > 0){
            int i = students.indexOf(students1.get(0));
            students.set(i, student);
        }
    }
    public List<Student> getStudentsByMajor(String major){
        return  students.stream().filter(s->s.getMajor().equals(major)).toList();
    }
    public List<Course> getCoursesByStudentId(int studentId){
        return students.stream()
                .filter(s -> s.getId() == studentId)
                .flatMap(s -> s.getCoursesTaken().stream())
                .toList();
    }
}
