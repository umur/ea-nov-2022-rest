package edu.miu.rest.phasetwo.repository;

import edu.miu.rest.phasetwo.entity.Course;
import edu.miu.rest.phasetwo.entity.Student;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
public interface StudentRepository {

    List<Student> findStudentsByMajor(String major);

    List<Course> findCoursesByStudent(Long studentId);

    Student save(Student s);

    Student update(Long id, Student s);

    Boolean deleteById(Long id);

    Student findById(Long id);
}
