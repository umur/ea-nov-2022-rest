package edu.miu.phraseI.service;

import edu.miu.phraseI.entity.Course;
import edu.miu.phraseI.entity.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    List<Student> findAll();
    Student getById(int id);
    void delete(int id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int id);

    interface CourseService {

        void save(Course course);

        List<Course> findAll();
        Course getById(Integer id);
        void update(Integer id, Course course);
        void delete(Integer id);
    }
}
