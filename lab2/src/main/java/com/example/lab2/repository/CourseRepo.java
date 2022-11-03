package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    static Course fpp;
    static Course mpp;
    static Course wap;
    static Course ea;

    static {
         fpp = new Course(1, "FPP", "CS3909C");
         mpp = new Course(2, "MPP", "CS40110C");
         wap = new Course(3, "WAP", "CS47212");
         ea = new Course(4, "EA", "CS54411");

        courses.add(fpp);
        courses.add(mpp);
        courses.add(wap);
        courses.add(ea);
    }

    public Course findById(int id) {
        return courses.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .get();
    }

    public List<Course> getAll() {
        return courses;
    }

    public void add(Course course) {
        courses.add(course);
    }

    public void update(int id, Course s) {
        Course courseToUpdate = findById(id);

        int index = courses.indexOf(courseToUpdate);
        courses.set(index, s);
    }

    public void delete(int id) {
        Course courseToDelete = findById(id);

        int index = courses.indexOf(courseToDelete);
        courses.remove(index);
    }
}
