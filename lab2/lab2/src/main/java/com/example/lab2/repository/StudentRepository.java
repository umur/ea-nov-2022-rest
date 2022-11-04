package com.example.lab2.repository;

import com.example.lab2.entity.course.Course;
import com.example.lab2.entity.student.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    static List<Student> students=new ArrayList<>();

    static {
       Student justice= new Student(1,"Justice","Manu","jay@email.com","Compro",4.0,new ArrayList<>());
       Student manu= new Student(1,"Justice","Manu","jay@email.com","math",4.0,new ArrayList<>());
        students.add(justice);
        students.add(manu);
    }


    public List<Student> getAllStudent(){
        return students;
    }

    public Student getOneStudent(Integer id){
        return students.stream().filter(val-> val.getId() == id).collect(Collectors.toList()).get(0);
    }

    public void addStudent(Student student){
//        int count=students.size();
//        Student c=new Course(count+1,co);
          students.add(student);
    }


}
