package miu.edu.ea_day2.services;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day2.models.Course;
import miu.edu.ea_day2.models.Student;
import org.springframework.stereotype.Service;
import miu.edu.ea_day2.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    public void update(int id, Student student) {
        studentRepository.update(id, student);
    }

    public List<Student> getStudentByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }
}
