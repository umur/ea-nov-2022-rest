package miu.edu.phaseone.service;

import lombok.RequiredArgsConstructor;
import miu.edu.phaseone.dto.CourseDTO;
import miu.edu.phaseone.dto.StudentDTO;
import miu.edu.phaseone.model.Student;
import miu.edu.phaseone.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    private final ModelMapper mapper;

    public List<StudentDTO> findAll() {
        return repository.findAll().stream().map(student -> mapper.map(student, StudentDTO.class)).collect(Collectors.toList());
    }

    public Optional<StudentDTO> findOne(Long id) {
        return repository.findOne(id).map(student -> mapper.map(student, StudentDTO.class));
    }

    public StudentDTO save(StudentDTO student) {
        return mapper.map(repository.save(mapper.map(student, Student.class)), StudentDTO.class);
    }

    public void deleteOne(Long id) {
        repository.deleteOne(id);
    }

    public List<StudentDTO> getStudentsByMajor(String major) {
        return repository.getStudentsByMajor(major).stream().map(student -> mapper.map(student, StudentDTO.class)).collect(Collectors.toList());
    }

    public List<CourseDTO> getCoursesByStudentId(Long studentId) {
        return repository.getCoursesByStudentId(studentId).stream().map(student -> mapper.map(student, CourseDTO.class)).collect(Collectors.toList());
    }

}
