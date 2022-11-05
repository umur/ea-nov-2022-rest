package edu.miu.phraseI.service.imp;

import edu.miu.phraseI.entity.Course;
import edu.miu.phraseI.entity.Student;
import edu.miu.phraseI.repo.CourseRepo;
import edu.miu.phraseI.repo.StudentRepo;
import edu.miu.phraseI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {


    StudentRepo studentRepo;

    @Autowired
    public StudentServiceImp(StudentRepo studentRepo){
        this.studentRepo= studentRepo;
    }




    public void save(Student student) {
        studentRepo.add(student);

    }

    public List<Student> findAll() {
        return studentRepo.getAll();
    }

    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    public void delete(int id) {
            studentRepo.deleteById(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
