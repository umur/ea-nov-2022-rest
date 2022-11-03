package com.eanov2022rest.eanov2022rest.repo;

import com.eanov2022rest.eanov2022rest.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    static {
        var s1 = new Course();
        var s2 = new Course();
        var s3 = new Course();

    }

    public List<Course> getAll() { return courses; }
    public void add(Course course) { courses.add(course); }
}
