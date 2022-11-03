package com.ea.api.repository;

import com.ea.api.entity.Course;
import com.ea.api.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students;
    private static List<Course> courses;

    static {
        students= new ArrayList<>();
        courses= new ArrayList<>();
        var c1 = new Course(1, "EA", 544);
        var c2 = new Course(2, "SA", 590);
        var c3 = new Course(3, "WAP", 470);
        var c4 = new Course(4, "Algo", 472);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

        var s1 = new Student(1, "esme", "mih", "em@gmail.com", "cs", 3.8, new ArrayList<>());
        var s2 = new Student(2, "john", "Dave", "john@gmail.com", "cs", 3.86, new ArrayList<>());
        var s3 = new Student(3, "David", "Thomas", "dav@gmail.com", "Compro", 3.9, new ArrayList<>());
        var s4 = new Student(4, "Dawit", "Sander", "dawit@gmail.com", "Compro", 3.8, new ArrayList<>());
        var s5 = new Student(5, "em", "me", "em@gmail.com", "cs", 3.75, new ArrayList<>());

        s1.getCoursesTaken().add(c1);
        s1.getCoursesTaken().add(c2);
        s2.getCoursesTaken().add(c2);
        s2.getCoursesTaken().add(c3);
        s3.getCoursesTaken().add(c3);
        s3.getCoursesTaken().add(c3);
        s4.getCoursesTaken().add(c2);
        s4.getCoursesTaken().add(c4);
        s5.getCoursesTaken().add(c1);
        s5.getCoursesTaken().add(c4);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }
    //Get method
    public List<Student> getAllStudents() {
        return students;
    }
    //post or Create method
    public Student createStudent(Student student){
        Student stud=new Student();
        stud.setId(stud.getId());
        stud.setFirstName(stud.getFirstName());
        stud.setLastName(stud.getLastName());
        stud.setEmail(stud.getEmail());
        stud.setGpa(stud.getGpa());
        stud.setMajor(stud.getMajor());
        stud.setCoursesTaken(stud.getCoursesTaken());
        return stud;
    }

    public void deleteStudent(int id){
        students.removeIf(x->x.getId()==id);
    }
    public Student updateStudents(Student student){
        int newId=0;
        int id=0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId()==student.getId()){
                id=student.getId();
                newId=i;
                break;
            }

        }
        Student updatedStudent=new Student();
        updatedStudent.setId(id);
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setMajor(student.getMajor());
        updatedStudent.setGpa(student.getGpa());
        updatedStudent.setCoursesTaken(student.getCoursesTaken());
        students.set(newId, student);
        return updatedStudent;
    }

    public List<Student> getStudentsByMajor(String major){
        return students.stream().filter(x -> x.getMajor().equals(major)).collect(Collectors.toList());
    }
 public List<Course> getCoursesByStudentId(int studentId){
        return students.stream().filter(s->s.getId()==studentId).findAny()
                .orElseThrow(()-> new RuntimeException("Student does not exist with this Id"))
                .getCoursesTaken();
 }
}
