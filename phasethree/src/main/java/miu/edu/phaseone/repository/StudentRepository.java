package miu.edu.phaseone.repository;

import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentRepository {
    List<Student> students = new ArrayList<>();
    private static long randomId() {
        return (long) (1 + (Math.random() * (1000000 - 1)));
    }
    public List<Student> findAll() {
        return students;
    }

    public Student save(Student student) {
        Optional<Student> optional = findOne(student.getId());
        if (optional.isPresent()) {
            int index = students.indexOf(optional.get());
            students.get(index).setEmail(student.getEmail());
            students.get(index).setFirstName(student.getFirstName());
            students.get(index).setLastName(student.getLastName());
            students.get(index).setGpa(student.getGpa());
            students.get(index).setMajor(student.getMajor());
        } else {
            student.setId(randomId());
            students.add(student);
        }
        return student;
    }

    public Optional<Student> findOne(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findAny();
    }

    public void deleteOne(Long id) {
        this.students = this.students.stream().filter(student -> !student.getId().equals(id)).collect(Collectors.toList());
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return findOne(studentId).map(Student::getCoursesTaken).orElse(new ArrayList<>());
    }
}
