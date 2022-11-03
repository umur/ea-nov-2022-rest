package com.example.EA.Lab2.Service.Impl;

import com.example.EA.Lab2.Entity.Course;
import com.example.EA.Lab2.Entity.Student;
import com.example.EA.Lab2.Repository.StudentRepo;
import com.example.EA.Lab2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepo studentRepo;

    public List<Student> findAll(){
        return studentRepo.findAll();
    }

    public Student save(Student student){
        return studentRepo.save(student);
    }
    public Student update(Integer Id, Student student){
        Optional<Student> updating = studentRepo.findById(Id);
        if(updating.isPresent()){
            return studentRepo.save(updating.get());
        } return null;
    }
    public Student findOne(Integer Id){
        Optional<Student> found = studentRepo.findById(Id);
        if(found.isPresent()){
            return found.get();
        } return null;
    }
    public void delete(Integer Id){
        studentRepo.deleteById(Id);
    }
    public List<Student> getStudentsByMajor(String major){
    return studentRepo.findByMajor(major);
    };
    public List<Course> getCoursesByStudentId(Integer Id){
        return studentRepo.findById(Id).get().getCoursesTaken();
    }
}
