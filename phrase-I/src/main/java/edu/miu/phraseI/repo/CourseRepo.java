package edu.miu.phraseI.repo;

import edu.miu.phraseI.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    List<Course> courses = new ArrayList<>();

    private int currentId = 0;

    public void add(Course course){
        course.setId(++currentId);
        courses.add(course);
    }

    public List<Course> findAll(){
        return courses;
    }

    public Course getById(Integer id){
        return courses.stream()
                .filter(c->c.getId()==id)
                .findFirst().orElse(null);
    }

    public void update(Integer id, Course course){
        courses.stream()
                .filter(c->c.getId()==id)
                .findFirst()
                .ifPresent(v-> {
                    v.setName(course.getName());
                    v.setCode(course.getCode());
                });
    }

    public void delete(Integer id){
        courses.removeIf(c->c.getId()==id);
    }
}
