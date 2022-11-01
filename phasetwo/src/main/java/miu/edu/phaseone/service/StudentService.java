package miu.edu.phaseone.service;

import lombok.RequiredArgsConstructor;
import miu.edu.phaseone.dto.CourseDTO;
import miu.edu.phaseone.dto.StudentDTO;
import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.model.Student;
import miu.edu.phaseone.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<StudentDTO> findAll() {
        return repository.findAll().stream().map(Student::toDTO).collect(Collectors.toList());
    }

    public Optional<StudentDTO> findOne(Long id) {
        return repository.findOne(id).map(Student::toDTO);
    }

    public StudentDTO save(StudentDTO course) {
        return repository.save(course.toEntity()).toDTO();
    }

    public void deleteOne(Long id) {
        repository.deleteOne(id);
    }

    public List<StudentDTO> getStudentsByMajor(String major) {
        return repository.getStudentsByMajor(major).stream().map(Student::toDTO).collect(Collectors.toList());
    }

    public List<CourseDTO> getCoursesByStudentId(Long studentId) {
        return repository.getCoursesByStudentId(studentId).stream().map(Course::toDTO).collect(Collectors.toList());
    }

}
