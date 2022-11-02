package com.example.lab2.rest.repository;

import com.example.lab2.rest.model.Course;
import com.example.lab2.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    static List<Student> students = new ArrayList<>();
    static {
        List<Course> list1 = new ArrayList<>();
        list1.add(CourseRepository.courses.get(0));
        list1.add(CourseRepository.courses.get(1));
        Student s1 = new Student(1, "John", "Higgins", "john@gmail.com", "bigdata", 3.8, list1);

        List<Course> list2 = new ArrayList<>();
        list2.add(CourseRepository.courses.get(2));
        Student s2 = new Student(2, "Pat", "Higgins", "pat@gmail.com", "", 3.9, list2);

        List<Course> list3 = new ArrayList<>();
        list3.add(CourseRepository.courses.get(1));
        list3.add(CourseRepository.courses.get(2));
        Student s3 = new Student(3, "Nick", "Higgins", "nick@gmail.com", "", 3.7, list3);

        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public List<Student> getAll(){
        return students;
    }

    public List<Student> getStudentsByMajor(String major){
        return students.stream().filter( s -> s.getMajor().equals(major)).toList();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void deleteStudent(int studentId){
        students = students.stream().filter(c -> c.getId() != studentId).toList();
    }

    public void updateStudent(Student student, int id){
        Student studentToUpdate = students.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        int curIndex = students.indexOf(studentToUpdate);
        students.set(curIndex, student);
    }
}
