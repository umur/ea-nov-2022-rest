package miu.edu.ealab2restphase1.repository;

import miu.edu.ealab2restphase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private List<Student> students = new ArrayList<>();

    public List<Student> findAllStudents(){
        return students.stream()
                .filter(a->!a.isDeleted())
                .collect(Collectors.toList());
    }

    public Optional<Student> findStudentById(int id){
        return students.stream()
                .filter(a->a.getId() == id)
                .findFirst();
    }

    public Student save(Student course){
        students.add(course);
        return course;
    }

    public void delete(int id){
        students.stream().filter(a->a.getId()==id)
                .findAny().ifPresent(a->a.setDeleted(true));
    }

}
