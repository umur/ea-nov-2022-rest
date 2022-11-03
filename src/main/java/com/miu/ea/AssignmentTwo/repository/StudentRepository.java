package com.miu.ea.AssignmentTwo.repository;

import com.miu.ea.AssignmentTwo.entity.Course;
import com.miu.ea.AssignmentTwo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    public static List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudent() {
        return studentList;
    }

    public boolean addStudent(Student student) {
        studentList.add(student);
        return true;
    }

    public boolean updateStudent(Long studentId, Student student) {
        for (Student updateStudent : studentList) {
            if (updateStudent.getId().equals(studentId)) {
                updateStudent.setId(student.getId());
                updateStudent.setEmail(student.getEmail());
                updateStudent.setGpa(student.getGpa());
                updateStudent.setMajor(student.getMajor());
                updateStudent.setFirstName(student.getFirstName());
                updateStudent.setLastName(student.getLastName());
                updateStudent.setCourseTaken(student.getCourseTaken());
            }
        }
        return true;
    }

    public boolean deleteStudent(Long studentId) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(studentId)) {
                iterator.remove();
            }
        }
        return true;
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentList
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        for (Student student : studentList) {
            if (student.getId().equals(studentId)) {
                return student.getCourseTaken();
            }
        }
        return null;
    }

}
