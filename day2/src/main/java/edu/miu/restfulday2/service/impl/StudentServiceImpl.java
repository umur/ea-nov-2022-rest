package edu.miu.restfulday2.service.impl;

import edu.miu.restfulday2.entity.Student;
import edu.miu.restfulday2.entity.dto.StudentDTO;
import edu.miu.restfulday2.repo.StudentRepo;
import edu.miu.restfulday2.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO save(StudentDTO student) {
        Student student1 = studentRepo.save(modelMapper.map(student, Student.class));
        return  modelMapper.map(student1, StudentDTO.class);

    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> student = studentRepo.getStudentList();
        return student.stream().map(student1 -> modelMapper.map(student1, StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO update(StudentDTO student) {
        Student student1 = studentRepo.update(modelMapper.map(student, Student.class));
        return modelMapper.map(student1, StudentDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        return studentRepo.delete(id);
    }
}
