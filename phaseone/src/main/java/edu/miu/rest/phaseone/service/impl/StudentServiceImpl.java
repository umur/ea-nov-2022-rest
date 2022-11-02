package edu.miu.rest.phaseone.service.impl;

import edu.miu.rest.phaseone.entity.Course;
import edu.miu.rest.phaseone.entity.Student;
import edu.miu.rest.phaseone.exception.StudentException;
import edu.miu.rest.phaseone.repository.StudentRepository;
import edu.miu.rest.phaseone.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudentByMajor(String major) {
        if (!StringUtils.hasText(major)) {
            throw new StudentException("Provide invalid major");
        }
        return studentRepository.findStudentsByMajor(major.toUpperCase());
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepository.findCoursesByStudent(studentId);
    }

    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public Student update(Long id, Student s) {
        return studentRepository.update(id, s);
    }

    @Override
    public Boolean deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }
}
