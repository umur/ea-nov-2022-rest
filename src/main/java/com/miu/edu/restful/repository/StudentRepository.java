package com.miu.edu.restful.repository;

import com.miu.edu.restful.entity.Student;

import java.util.List;

public interface StudentRepository {

    /**
     * Get all students
     * @return a list of all students
     */
    List<Student> getAllStudents();

    /**
     * Get stydent by major
     * @param major
     * @return a list of students
     */
    List<Student> getStudentsByMajor(String major);

    /**
     * Get student by id
     * @param id
     * @return Student
     */
    Student getById(int id);

    /**
     * Update student
     * @param student
     */
    void updateStudent(Student student);

    /**
     * Add a new student
     * @param student
     */
    void add(Student student);

    /**
     * Remove a student by id
     * @param id
     */
    void removeById(int id);
}
