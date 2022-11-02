package edu.miu.restfulday2.service;

import edu.miu.restfulday2.entity.Student;
import edu.miu.restfulday2.entity.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO save(StudentDTO student);

    public List<StudentDTO> getAll();

    public StudentDTO update(StudentDTO student);

    boolean delete(Integer id);
}
