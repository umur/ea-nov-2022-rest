package miu.edu.ealab2restphase1.service.impl;

import miu.edu.ealab2restphase1.entity.Course;
import miu.edu.ealab2restphase1.entity.Student;
import miu.edu.ealab2restphase1.repository.CourseRepo;
import miu.edu.ealab2restphase1.repository.StudentRepo;
import miu.edu.ealab2restphase1.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements GenService<Student> {
    
    @Autowired
    private StudentRepo studentRepo;
    
    @Override
    public List<Student> findAll() {
        return studentRepo.findAllStudents();
    }

    @Override
    public Optional<Student> find(int id) {
        return studentRepo.findStudentById(id);
    }

    @Override
    public Student save(Student item) {
        return studentRepo.save(item);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }
}
