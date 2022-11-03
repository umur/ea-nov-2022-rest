package com.ea.api.service.impl;

import com.ea.api.entity.Course;
import com.ea.api.entity.Student;
import com.ea.api.repository.StudentRepo;
import com.ea.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudent() {

        return studentRepo.getAllStudents();
    }
    @Override
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.createStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.updateStudents(student);

    }
    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }


    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
