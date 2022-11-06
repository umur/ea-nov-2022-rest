package ea.nov.rest.repository;

import ea.nov.rest.model.Course;
import ea.nov.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student s)
    {
        studentList.add(s);
    }
//
//    public void addStudent(Student s,List<Course> courses){
//        s.getCoursesTaken().addAll(courses);
//        studentList.add(s);
//    }

    public List<Student> getStudentsByMajor(String major)
    {
        return studentList.stream().filter(s->s.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId){
        return studentList.stream().filter(s-> s.getId() == studentId).findFirst().orElse(new Student()).getCoursesTaken();
    }

    public Student getByStudentId(int id){
        studentList.forEach(System.out::println);
        return studentList.stream().filter(s->s.getId() == id).findFirst().orElse(new Student());
    }
}
