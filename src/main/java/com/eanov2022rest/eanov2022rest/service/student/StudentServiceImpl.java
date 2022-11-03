package com.eanov2022rest.eanov2022rest.service.student;

import com.eanov2022rest.eanov2022rest.entity.Course;
import com.eanov2022rest.eanov2022rest.entity.Student;
import com.eanov2022rest.eanov2022rest.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public Student add(Student student) {
        studentRepo.add(student);
        return student;
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        return studentRepo.updateStudent(id, student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteStudentById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
