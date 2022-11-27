package com.labs.lab2phase1.repository;

import com.labs.lab2phase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    public List<Student> listOfStudents=new ArrayList<>();

    public void addStudent(Student student){
        listOfStudents.add(student);
    }


    public Student getStudentById (int id){
        for (Student st: listOfStudents) {
            if(st.getId()==id) return st;
        }
        return null;
    }

   public List<Student> getAllStudents(){
        return listOfStudents;
   }

   public void deleteStudent(int id){
        List<Student> temp=listOfStudents.stream().filter(s->s.getId()!=id).toList();
        listOfStudents=temp;
   }

   public List<Student> getStudentsByMajor(String major){

        List<Student> temp=listOfStudents.stream()
                .filter(s->s.getMajor().equals(major)).toList();
        return temp;
   }
}
