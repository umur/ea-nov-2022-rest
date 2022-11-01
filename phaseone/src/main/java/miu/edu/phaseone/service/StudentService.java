package miu.edu.phaseone.service;

import lombok.RequiredArgsConstructor;
import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.model.Student;
import miu.edu.phaseone.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Optional<Student> findOne(Long id) {
        return repository.findOne(id);
    }

    public Student save(Student course) {
        return repository.save(course);
    }

    public void deleteOne(Long id) {
        repository.deleteOne(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return repository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return repository.getCoursesByStudentId(studentId);
    }

}
