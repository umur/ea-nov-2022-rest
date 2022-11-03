package lab2.restful.service;

import lab2.restful.models.Course;
import lab2.restful.models.Student;
import lab2.restful.repository.DB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    DB db;

    public StudentService(DB db){
        this.db = db;
    }

    public List<Student> getStudents(){
        return this.db.getStudents();
    }

    public Student getStudentById(String id){
        return this.db.getStudentById(id);
    }

    public boolean addStudent(Student s){
        return this.db.addStudent(s);
    }

    public boolean updateStudent(Student s, String id){
        return this.db.updateStudent(s, id);
    }

    public boolean deleteStudentById(String id){
        return this.db.deleteStudentById(id);
    }

    public List<Student> getStudentsByMajor(String major){
        List<Student> students = new ArrayList<>();
        this.getStudents().forEach(s -> {
            if(s.getMajor().equals(major)){
                students.add(s);
            }
        });
    return students;
    }

    public List<Course> getCoursesByStudentId(String id){
        return this.getStudentById(id).getCoursesTaken();
    }
}
