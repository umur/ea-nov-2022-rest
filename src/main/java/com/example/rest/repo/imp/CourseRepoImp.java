package com.example.rest.repo.imp;

import com.example.rest.entity.Course;
import com.example.rest.entity.Student;
import com.example.rest.repo.CourseRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepoImp implements CourseRepo {
    public static List<Course> courses = new ArrayList<>();
    static {
        Course c1 = new Course(1, "DBMS", "D255");
        Course c2 = new Course(2, "WAP", "W276");
        Course c3 = new Course(13, "EA", "EAWQ12");
        Course c4 = new Course(11, "ML", "ML542");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
    }

    public List<Course> getAll() {
        return courses;
    }

    public Course getCourseById(String id) {
        return courses.stream().filter(p -> Integer.valueOf(p.getId()).toString().equals(id)).findFirst().get();
    }

    public void create(Course p) {
        courses.add(p);
    }

    public Course update(String id, Course course){
        Course course1 = courses.stream().filter(p -> Integer.valueOf(p.getId()).toString().equals(id)).findFirst().orElse(null);
        int newId = course.getId();
        String code = course.getCode();
        String name = course.getName();

        course1.setId(newId);
        course1.setName(name);
        course1.setCode(code);

        return  course;
    }

    public void delete(String id) {
        Course target = courses.stream().filter(p -> Integer.valueOf(p.getId()).toString().equals(id)).findFirst().orElse(null);
        courses.remove(target);
    }

    @Override
    public List<Course> getCoursesByStudentId(String id) {
        Student student = StudentRepoImp.students.stream().filter(s -> Integer.valueOf(s.getId()).toString().equals(id)).findFirst().orElse(null);
        if (student == null) {
            throw new IllegalArgumentException("no student id found");
        }
        return new ArrayList<>(student.getCourses());
    }
}
