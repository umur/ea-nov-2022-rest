package miu.edu.ealab2restphase1.service.impl;

import miu.edu.ealab2restphase1.entity.Course;
import miu.edu.ealab2restphase1.entity.Student;
import miu.edu.ealab2restphase1.repository.StudentRepo;
import miu.edu.ealab2restphase1.service.GenService;
import miu.edu.ealab2restphase1.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private GenService<Course> courseGenService;

    @Autowired
    private GenService<Student> studentGenService;

    @Override
    public void assignCourse(int studentId, int courseId) {
        Optional<Course> course = courseGenService.find(courseId);
        Optional<Student> student = studentGenService.find(studentId);

        if(course.isEmpty() || student.isEmpty()){
            throw new NoSuchElementException();
        }

        student.ifPresent(a->a.addCourse(course.get()));
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentGenService.findAll().stream()
                .filter(a->a.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> getCourseByStudentId(int id) {
        return studentGenService.findAll()
                .stream().filter(a->a.getId() == id)
                .findAny().map(Student::getCourseTaken)
                .orElse(new ArrayList<>());
    }
}
