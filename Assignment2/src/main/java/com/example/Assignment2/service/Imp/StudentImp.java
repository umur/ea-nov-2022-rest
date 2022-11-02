package com.example.Assignment2.service.Imp;

import com.example.Assignment2.Entity.Student;
import com.example.Assignment2.Entity.StudentCourses;
import com.example.Assignment2.reposotiry.CourseRepo;
import com.example.Assignment2.reposotiry.StudentCourseRepo;
import com.example.Assignment2.reposotiry.StudentRepo;
import com.example.Assignment2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImp implements StudentService {

    @Autowired
    StudentRepo repo;
    @Autowired
    StudentCourseRepo stcorepo;

    @Override
    public void add(Student s) {
        repo.add(s);
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }

    public void update(int id, Student s) {
        repo.update(id, s);
    }

    public List<Student> getAll() {
        return repo.getAllStudent();
    }

    public List<StudentCourses> getStudentCourses(int studentID) {
        return stcorepo.getCoursesByStudentId(studentID);
    }

    public List<Student> getStudentByMajor(String major) {
        return repo.getStudentsByMajor(major);
    }

}
