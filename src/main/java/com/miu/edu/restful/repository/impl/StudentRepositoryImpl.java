package com.miu.edu.restful.repository.impl;

import com.miu.edu.restful.data.Data;
import com.miu.edu.restful.entity.Student;
import com.miu.edu.restful.exception.NotFoundException;
import com.miu.edu.restful.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> students = Data.getStudents();

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .toList();
    }

    @Override
    public Student getById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElseThrow(() -> new NotFoundException("Can't find the student with id " + id));
    }

    @Override
    public void updateStudent(Student student) {
        Optional<Student> stu = students.stream()
                .filter(s -> s.getId() == student.getId())
                .findAny();

        stu.ifPresent(s -> {
            if (student.getFirstName() != null) {
                s.setFirstName(student.getFirstName());
            }

            if (student.getLastName() != null) {
                s.setLastName(student.getLastName());
            }

            if (student.getEmail() != null) {
                s.setEmail(student.getEmail());
            }

            if (student.getGpa() > 0) {
                s.setGpa(student.getGpa());
            }

            if (student.getCoursesTaken() != null && !student.getCoursesTaken().isEmpty()) {
                s.setCoursesTaken(student.getCoursesTaken());
            }
        });
    }

    @Override
    public void add(Student student) {
        student.setId(Data.currentStudentId++);
        students.add(student);
    }

    @Override
    public void removeById(int id) {
        Optional<Student> student = students.stream()
                .filter(s -> s.getId() == id)
                .findAny();
        student.ifPresent(students::remove);
    }
}
