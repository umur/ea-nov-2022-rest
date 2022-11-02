package edu.miu.rest.phaseone.service;

import edu.miu.rest.phaseone.entity.Course;
import edu.miu.rest.phaseone.entity.Student;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
public interface StudentService {
    List<Student> getStudentByMajor(String major);

    List<Course> getCoursesByStudentId(Long studentId);

    Student save(Student s);

    Student update(Long id, Student s);

    Boolean deleteById(Long id);

    Student findById(Long id);
}
