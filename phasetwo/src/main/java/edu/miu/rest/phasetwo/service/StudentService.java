package edu.miu.rest.phasetwo.service;

import edu.miu.rest.phasetwo.dtos.CourseDTO;
import edu.miu.rest.phasetwo.dtos.StudentDTO;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
public interface StudentService {
    List<StudentDTO> getStudentByMajor(String major);

    List<CourseDTO> getCoursesByStudentId(Long studentId);

    StudentDTO save(StudentDTO s);

    StudentDTO update(Long id, StudentDTO s);

    Boolean deleteById(Long id);

    StudentDTO findById(Long id);
}
