package com.example.Assignment2.reposotiry;

import com.example.Assignment2.Entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
    static List<Course> lc = new ArrayList<>();

    static {
        Course c1 = new Course(1, "CourseOne", "c1");
        Course c2 = new Course(1, "CourseTwo", "c2");
        Course c3 = new Course(1, "CourseThree", "c3");
        Course c4 = new Course(1, "CourseFour", "c4");
        lc.add(c1);
        lc.add(c2);
        lc.add(c3);
        lc.add(c4);
    }

    public List<Course> getAll() {
        return lc;
    }

    public void delete(int id) {
        lc.removeIf(c -> c.getId() == id);
    }
    public void add(Course c ){
        lc.add(c);
    }

    public void updateCourse(Course c, int id) {
        Optional<Course> optCourse = lc.stream().
                filter(x -> x.getId() == id).findFirst();
        if (optCourse.isPresent()) {
            optCourse.get().setCode(c.getCode());
            optCourse.get().setName(c.getName());
        }
    }


}
