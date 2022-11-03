package com.eanov2022rest.eanov2022rest.service.student;

import com.eanov2022rest.eanov2022rest.entity.Course;
import com.eanov2022rest.eanov2022rest.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();
    public Student add(Student student);
    public Student getStudentById(int id);
    public Student updateStudent(int id,  Student student);
    public void deleteStudentById(int id);
    public List<Student> getStudentsByMajor(String major);

    public List<Course> getCoursesByStudentId(int StudentId);

}
