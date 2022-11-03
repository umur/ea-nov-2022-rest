package com.example.eanov2022rest.service;

import com.example.eanov2022rest.entity.Student;
import com.example.eanov2022rest.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpl  implements StudentService{
    private final StudentRepo studentRepo;

    @Override
    public void updateStudent (Integer id,String email,String major) {
        studentRepo.update(id,email,major);
    }

    @Override
    public void deleteStudent (Integer id) {
        studentRepo.delete(id);
    }

    @Override
    public List <Student> getAll () {
        return studentRepo.getAll ();
    }

//    @Override
//    public Student getStudentById (Integer id) {
//
//        return studentRepo.findById(id);
//    }

    @Override
    public void createStudent (Student student) {
        studentRepo.create(student);

    }

    @Override
    public List <Student> getStudentsByMajor (String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public Student getById (Integer id) {
        return studentRepo.findById (id);
    }
}
