package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    static List<Student> list = new ArrayList<>();

    static {
        var s1 = new Student(1, "FirstName 1", "SureName 1", "student1@gmail.com", "M1", 3.6f, CourseRepository.list);
        var s2 = new Student(2, "FirstName 2", "SureName 2", "student2@gmail.com", "M2", 3.7f, CourseRepository.list);
        var s3 = new Student(3, "FirstName 3", "SureName 3", "student3@gmail.com", "M3", 3.3f, CourseRepository.list);

        list.add(s1);
        list.add(s2);
        list.add(s3);

    }

    public List<Student> getAll(){
        return list;
    }

    public List<Student> getStudentsByMajor(String major){
        return list.stream().filter(l -> {
            return l.getMajor().equals(major);
        }).toList();
    }

    public List<Course> getCoursesByStudentId(Integer id){
        int index = findIndex(id);
        return list.get(index).getCoursesTaken();
    }

    public void add(Student s){
        list.add(s);
    }

    public Student one(Integer id){
        int index = this.findIndex(id);
        return list.get(index);
    }

    public void update(Integer id, Student s){
        int index = this.findIndex(id);
        list.add(index, s);
    }

    public void delete(Integer id){
        int index = this.findIndex(id);
        list.remove(index);
    }

    public Integer findIndex(Integer id){
        int index = -1;
        for (Student s: list){
            index++;
            if(s.getId() == id)
                return index;
        }

        return -1;
    }

}
