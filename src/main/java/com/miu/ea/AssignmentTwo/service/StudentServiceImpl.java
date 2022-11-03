package com.miu.ea.AssignmentTwo.service;

import com.miu.ea.AssignmentTwo.entity.Course;
import com.miu.ea.AssignmentTwo.entity.Student;
import com.miu.ea.AssignmentTwo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public boolean addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public boolean updateStudent(Long studentId, Student student) {
        return studentRepository.updateStudent(studentId, student);
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        return studentRepository.deleteStudent(studentId);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}
