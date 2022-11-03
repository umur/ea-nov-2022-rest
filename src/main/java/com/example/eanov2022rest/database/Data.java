package com.example.eanov2022rest.database;

import com.example.eanov2022rest.entity.Course;
import com.example.eanov2022rest.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List <Student> studentList = new ArrayList <> ();
    public static List <Course> coursesList = new ArrayList <> ();

    static {
        studentList.addAll (initStudents ());
        coursesList.addAll (initCourses());

        Student st1 = studentList.get (0);
        Student st2 = studentList.get (1);
        Student st3 = studentList.get (2);
        Student st4 = studentList.get (3);

        Course course1 = coursesList.get (0);
        Course course2 = coursesList.get (1);
        Course course3 = coursesList.get (2);


        st1.getCoursesTaken ().add (course1);
        st1.getCoursesTaken ().add (course2);
        st1.getCoursesTaken ().add (course3);



        st2.getCoursesTaken ().add (course1);
        st2.getCoursesTaken ().add (course2);
        st2.getCoursesTaken ().add (course3);

        st3.getCoursesTaken ().add (course1);
        st3.getCoursesTaken ().add (course2);
        st3.getCoursesTaken ().add (course3);


        st4.getCoursesTaken ().add (course1);
        st4.getCoursesTaken ().add (course2);
        st4.getCoursesTaken ().add (course3);


    }

    private static List<Student> initStudents(){
        var students = new ArrayList<Student> ();
        var student1 = new Student (1,"Alex","Thompson","alex@gmail.com","Computer Science","3.7","1234");
        var student2 = new Student (2,"Kelvin","Tran","kelvin@gmail.com","Computer Science","3.9","1235");
        var student3 = new Student (3,"Kim","Thomas","kim@gmail.com","Data Science","3.8","1236");
        var student4 = new Student (4,"Le","Viet","le@gmail.com","Data Science","3.9","1436");

        students.add (student1);
        students.add (student2);
        students.add (student3);
        students.add (student4);

        return students;

    }

    private static List<Course> initCourses(){
        var courses = new ArrayList<Course>();
        var course1 = new Course (1,"Algo","1111");
        var course2 = new Course (2,"MWA","2222");
        var course3 = new Course (3,"SA","3333");

        courses.add (course1);
        courses.add (course2);
        courses.add (course3);

        return courses;

    }
}
