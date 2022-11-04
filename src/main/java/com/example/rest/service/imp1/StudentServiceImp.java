package com.example.rest.service.imp1;

import com.example.rest.entity.Student;
import com.example.rest.repo.StudentRepo;
import com.example.rest.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public void create(Student p) throws Exception {
        studentRepo.create(p);
    }

    @Override
    public Student update(String id, Student p) {
        return studentRepo.update(id, p);
    }

    @Override
    public void delete(String id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
