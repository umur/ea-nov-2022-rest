package com.miu.edu.restful.repository;

import com.miu.edu.restful.entity.Course;

import java.util.List;

public interface CourseRepository {

    /**
     * Get all Courses
     * @return Courses
     */
    List<Course> getAllCourses();

    /**
     * Get Courses by student id
     * @param studentId
     * @return List of courses belong to student
     */
    List<Course> getCoursesByStudentId(int studentId);

    /**
     * Get course by id
     * @param id
     * @return course
     */
    Course getById(int id);

    /**
     * Update Course
     * @param course
     */
    void updateCourse(Course course);

    /**
     * Add course
     * @param course
     */
    void addCourse(Course course);

    /**
     * Remove Course by id
     * @param id
     */
    void removeById(int id);
}
