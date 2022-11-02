package com.miu.edu.restful.data;

import com.miu.edu.restful.entity.Course;
import com.miu.edu.restful.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    public static int currentStudentId = 1;
    public static int currentCourseId = 1;

    static {
        students.addAll(generateStudents());
        courses.addAll(generateCourses());
    }

    public static List<Student> generateStudents() {
        var students = new ArrayList<Student>();
        var s1 = new Student(currentStudentId++, "Ba Luan", "Tran", "ba.tran@miu.edu", "Compro", 4.0);
        s1.setCoursesTaken(courses);
        var s2 = new Student(currentStudentId++, "Thomas", "Tran", "thomas.tran@miu.edu", "Compro", 4.0);
        s2.setCoursesTaken(courses);
        var s3 = new Student(currentStudentId++, "Loki", "Tran", "loki.tran@miu.edu", "BA", 4.0);
        s3.setCoursesTaken(courses);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        return students;
    }

    private static List<Course> generateCourses() {
        var courses = new ArrayList<Course>();
        courses.add(new Course(currentCourseId++, "MPP", "001"));
        courses.add(new Course(currentCourseId++, "WAP", "002"));
        courses.add(new Course(currentCourseId++, "EA", "003"));
        courses.add(new Course(currentCourseId++, "BDT", "004"));
        return courses;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Course> getCourses() {
        return courses;
    }
}
