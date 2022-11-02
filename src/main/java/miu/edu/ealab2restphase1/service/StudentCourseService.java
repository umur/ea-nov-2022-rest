package miu.edu.ealab2restphase1.service;

import miu.edu.ealab2restphase1.entity.Course;
import miu.edu.ealab2restphase1.entity.Student;

import java.util.List;

public interface StudentCourseService {
    void assignCourse(int studentId,int courseId);
    List<Student> getStudentByMajor(String major);
    List<Course> getCourseByStudentId(int id);
}
