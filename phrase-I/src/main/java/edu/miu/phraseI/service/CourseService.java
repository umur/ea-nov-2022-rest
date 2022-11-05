package edu.miu.phraseI.service;

import edu.miu.phraseI.entity.Course;

import java.util.List;

public interface CourseService {

    void save(Course course);
    List<Course> findAll();
    Course getById(Integer id);
    void update(Integer id, Course course);
    void delete(Integer id);

}
