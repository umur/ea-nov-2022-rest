package edu.miu.rest.phasetwo.service.impl;

import edu.miu.rest.phasetwo.dtos.CourseDTO;
import edu.miu.rest.phasetwo.dtos.StudentDTO;
import edu.miu.rest.phasetwo.entity.Course;
import edu.miu.rest.phasetwo.entity.Student;
import edu.miu.rest.phasetwo.exception.StudentException;
import edu.miu.rest.phasetwo.repository.StudentRepository;
import edu.miu.rest.phasetwo.service.StudentService;
import edu.miu.rest.phasetwo.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getStudentByMajor(String major) {
        if (!StringUtils.hasText(major)) {
            throw new StudentException("Provide invalid major");
        }
        List<Student> students = studentRepository.findStudentsByMajor(major.toUpperCase());
        return students.stream().map(x -> Utils.entityToDto(x, new StudentDTO())).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(Long studentId) {
        List<Course> courses = studentRepository.findCoursesByStudent(studentId);
        return courses.stream().map(x -> Utils.entityToDto(x, new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public StudentDTO save(StudentDTO s) {
        return Utils.entityToDto(studentRepository.save(Utils.dtoToEntity(s, new Student())), s);
    }

    @Override
    public StudentDTO update(Long id, StudentDTO s) {
        return Utils.entityToDto(studentRepository.update(id, Utils.dtoToEntity(s, new Student())), s);
    }

    @Override
    public Boolean deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO findById(Long id) {
        return Utils.entityToDto(studentRepository.findById(id), new StudentDTO());
    }
}
