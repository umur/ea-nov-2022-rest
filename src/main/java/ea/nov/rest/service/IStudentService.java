package ea.nov.rest.service;

import ea.nov.rest.dto.StudentDto;
import ea.nov.rest.model.Course;
import ea.nov.rest.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public interface IStudentService {
    List<Student> getAll();

    void addStudent(Student s);
    void addStudent(StudentDto dto);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
    Student getByStudentId(int id);

    List<StudentDto> getAllDto();
}
