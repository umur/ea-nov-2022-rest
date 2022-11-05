package edu.miu.phraseI.repo;

import edu.miu.phraseI.entity.Course;
import edu.miu.phraseI.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    List<Student> students = new ArrayList<>();

    private int curId;
    public void add(Student student){
        student.setId(++curId);
        students.add(student);
    }

    public Student getById( int id){
        return students.stream()
                .filter(c-> c.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void deleteById(int id){
         students.removeIf(c->c.getId()==id);
    }



    public List<Student> getAll(){
        return students;
    }


    public List<Student> getStudentsByMajor(String major){
        return students.stream()
                .filter(c->c.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id){
        Student student =  students.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);

        return student.getCoursesTaken();
    }

}
