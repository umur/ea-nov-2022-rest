package com.example.restfulapi.Repository;

import com.example.restfulapi.Entity.Course;
import com.example.restfulapi.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class StudentRepo {
    List<Student> studentList = new ArrayList<>();

    public List<Student> getAll(){
        return studentList;
    }

    public void addNew(Student student){
        studentList.add(student);
    }

    public void delete(int id){
        studentList.remove(studentList.stream().filter(student -> student.getId() == id).toList().get(0));
    }

    public void update(Integer id, Student student){
        Student oldStudent = studentList.stream().filter(course1 -> course1.getId() == id).toList().get(0);
        oldStudent.setGpa(student.getGpa());
        oldStudent.setEmail(student.getEmail());
        oldStudent.setMajor(student.getMajor());
        oldStudent.setFirst_name(student.getFirst_name());
        oldStudent.setLast_name(student.getLast_name());
        oldStudent.setCoursesTaken(student.getCoursesTaken());
        addNew(student);
    }

    public List<Student> getStudentsByMajor(String major){
        return studentList.stream().filter(student -> student.getMajor().equals(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        return studentList.stream()
                .filter(student -> student.getId() == studentId)
                .toList().get(0).getCoursesTaken();
    }

    public void addStudentInCourse(int studentId, Course course){
        Student s = studentList.stream().filter(student -> student.getId() == studentId)
                .toList().get(0);
    }
}
