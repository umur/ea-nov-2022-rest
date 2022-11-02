package com.example.Assignment2.reposotiry;

import com.example.Assignment2.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {


    static List<Student> ls = new ArrayList<>();

    static {
        Student st1 = new Student(1, "student", "One", "s@m.edu", "CS", 3.8);
        Student st2 = new Student(2, "student", "Two", "s@m.edu", "CS", 2.5);
        Student st3 = new Student(3, "student", "Three", "s@m.edu", "CS", 3.5);
        ls.add(st1);
        ls.add(st2);
        ls.add(st3);
    }

    public List<Student> getAllStudent() {
        return ls;
    }

    public void delete(int id) {
        ls.removeIf(x -> x.getId() == id);
    }

    public void update(int id , Student s){
        Optional<Student> optStudent = ls.stream().
                filter(x -> x.getId() == id).findFirst();
        if (optStudent.isPresent()) {
            optStudent.get().setEmail(s.getEmail());
            optStudent.get().setFirstName(s.getFirstName());
            optStudent.get().setLastName(s.getLastName());
            optStudent.get().setGpa(s.getGpa());
            optStudent.get().setMajor(s.getMajor());
        }
    }

    public void add(Student s ){
        ls.add(s);
    }

    public List<Student> getStudentsByMajor(String major ){
        return ls.stream().filter(x->x.getMajor().equals(major)).collect(Collectors.toList());
    }


}
