package ea.nov.rest.service.impl;

import ea.nov.rest.dto.StudentDto;
import ea.nov.rest.model.Course;
import ea.nov.rest.model.Student;
import ea.nov.rest.repository.StudentRepo;
import ea.nov.rest.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
     ModelMapper mapper;


    public  StudentDto toDto(Student student) {
        return mapper.map(student, StudentDto.class);
//        StudentDto dto = new StudentDto();
//        dto.setFirstName(student.getFirstName());
//        dto.setLastName(student.getLastName());
//        dto.setCoursesTaken(student.getCoursesTaken());
//        return dto;
    }

    public  Student toStudent(StudentDto dto) {

        return mapper.map(dto, Student.class);
//        Student s = new Student();
//        s.setFirstName(dto.getFirstName());
//        s.setLastName(dto.getLastName());
//        s.setCoursesTaken(dto.getCoursesTaken());
//        return s;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getStudentList();
    }

    @Override
    public void addStudent(Student s) {
        studentRepo.addStudent(s);
    }

    public void addStudent(StudentDto dto) {
        studentRepo.addStudent(toStudent(dto));
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }

    @Override
    public Student getByStudentId(int id) {
        return studentRepo.getByStudentId(id);
    }

    @Override
    public List<StudentDto> getAllDto() {

//                return (studentRepo
//                .getStudentList()
//                .stream()
//                .map(s->mapper.map(s,StudentDto.class))
//                .collect(Collectors.toList()));
        return (studentRepo
                .getStudentList()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList()));

    }
}
