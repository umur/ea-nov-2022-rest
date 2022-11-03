package com.eanov2022rest.eanov2022rest.repo;

import com.eanov2022rest.eanov2022rest.entity.Course;
import com.eanov2022rest.eanov2022rest.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();

    static {

        var c1 = new Course(1, "EA", "EA20");
        var c2 = new Course(2, "SWA", "SWA20");
        var c3 = new Course(3, "WAA", "WAA20");
        var c4 = new Course(4, "WAP", "WAP20");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

        var s1 = new Student(1, "Locha", "Shres", "lochan@gmail.com", "computer science", 2017, courses);
        var s2 = new Student(1, "Locha", "Shres", "lochan@gmail.com", "computer science", 2017, courses);
        var s3 = new Student(1, "Locha", "Shres", "lochan@gmail.com", "computer science", 2017, courses);
        var s4 = new Student(1, "Locha", "Shres", "lochan@gmail.com", "computer science", 2017, courses);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
    }

    public List<Student> getAll() { return students; }

    public void add(Student student) { students.add(student); }

    public Student getStudentById(int id) {
        Student student = students.get(id);
        return student;
    }

    public Student updateStudent(int id, Student student) {
        Student newStudent = students.get(id);
        newStudent.setId(student.getId());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setGPA(student.getGPA());
        newStudent.setCoursesTaken(student.getCoursesTaken());
        newStudent.setMajor(student.getMajor());
        students.set(id, newStudent);
        return newStudent;
    }

    public void deleteStudentById(int id) {
        students.remove(id);
    }

    public List<Student> getStudentByMajor(String major) {
        List<Student> newStudents = new ArrayList<>();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if(student.getMajor().equals(major)) {
                newStudents.add(student);
            }
        }
        return newStudents;
    }

    public List<Course> getCoursesByStudentId(int studentId){
        List<Course> newCourses = new ArrayList<>();
        Student student = students.get(studentId);
        newCourses = student.getCoursesTaken();
        return newCourses;
    }

}
