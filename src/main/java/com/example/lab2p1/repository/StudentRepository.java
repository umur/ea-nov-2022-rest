package com.example.lab2p1.repository;

import com.example.lab2p1.entity.Course;
import com.example.lab2p1.entity.Student;
import com.example.lab2p1.exception.NotFoundException;
import com.example.lab2p1.factory.Factory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class StudentRepository {
    private List<Student> repository;

    public StudentRepository() {
        this.repository = Factory.students;
    }

    public Student save(Student student) {
        var createdStudent = new Student(Factory.generateStudentId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getMajor(), student.getGpa(), student.getCoursesTaken());
        this.repository.add(createdStudent);
        return createdStudent;
    }

    public Student getStudentById(int id) throws NotFoundException {
        return this.repository.stream().filter(s -> s.getId() == id).findFirst().orElseThrow(() -> new NotFoundException("Not Found Student"));
    }

    public void deleteStudentById(int id) throws NotFoundException {
        Student student = this.getStudentById(id);
        this.repository.remove(student);
    }

    public List<Student> getAllStudents() {
        return this.repository;
    }

    public List<Student> getStudentsByMajor(String major) {
        return this.repository.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) throws NotFoundException {
        return this.getStudentById(id).getCoursesTaken();
    }

    public Student updateStudent(int id, Student student) throws NotFoundException {
        Student s = getStudentById(id);
        if (student.getFirstName() != null) {
            s.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null) {
            s.setLastName(student.getLastName());
        }
        if (student.getEmail() != null) {
            s.setEmail(student.getEmail());
        }
        if(student.getGpa() != null){
            s.setGpa(student.getGpa());
        }
        if(student.getMajor() != null){
            s.setMajor(student.getMajor());
        }
        if(student.getCoursesTaken() != null){
            s.setCoursesTaken(student.getCoursesTaken());
        }
        return s;
    }

}
