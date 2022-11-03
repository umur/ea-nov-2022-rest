package com.example.eanov2022rest.repository;

import com.example.eanov2022rest.database.Data;
import com.example.eanov2022rest.entity.Course;
import com.example.eanov2022rest.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepo {
    private static int currentId = 7;


    public List<Student> getAll(){
        return Data.studentList;
    }

    public Student findById (Integer id) {
        return Data.studentList.stream()
                .filter (s->s.getId () == id)
                .findAny ()
                .orElseThrow (()->new RuntimeException ("Student id:"+id+"is not in List"));
    }

    public List<Student> getStudentsByMajor (String major) {
        return Data.studentList.stream()
                .filter (s->s.getMajor ().equals (major))
                .toList ();
    }

    public void create (Student student) {
        student.setId (currentId++);
        Data.studentList.add (student);
        System.out.println (Data.studentList);
    }

    public void update (Integer id,String email,String major) {
        Data.studentList.stream ()
                .filter (s->s.getId () == id)
                .findAny ()
                .ifPresent (s -> {
                    s.setEmail (email);
                    s.setMajor (major);
                });
    }

    public void delete (Integer id) {
        Optional <Student> student =  Data.studentList.stream ()
                .filter (s ->s.getId () == id)
                .findAny ();
        student.ifPresent (Data.studentList::remove);
    }
}
