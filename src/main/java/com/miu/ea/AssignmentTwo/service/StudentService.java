package com.miu.ea.AssignmentTwo.service;

import com.miu.ea.AssignmentTwo.entity.Course;
import com.miu.ea.AssignmentTwo.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudent();
    public boolean addStudent(Student student);

    public boolean updateStudent(Long id, Student student);

    public boolean deleteStudent(Long studentId);

    public List<Student> getStudentsByMajor(String major);

    public List<Course> getCoursesByStudentId(Long studentId);
}
