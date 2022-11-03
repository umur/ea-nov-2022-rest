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
public class CourseRepo {
private static int currentId = 5;
    public List<Course> getAll() {
        return Data.coursesList;
    }

    public Course findById (Integer id) {
        return Data.coursesList.stream ()
                .filter (m->m.getId () == id)
                .findAny ()
                .orElseThrow (()->new RuntimeException ("Can not find course with id:"+id));

    }

    public void create (Course course) {
       course.setId (currentId++);
       Data.coursesList.add (course);
       System.out.println (Data.coursesList);

    }

    public void update (Integer id,String name,String code) {
        Data.coursesList.stream ()
                .filter (s->s.getId () == id)
                .findAny ()
                .ifPresent (s -> {
                    s.setName (name);
                    s.setCode (code);
                });
    }

    public void delete (Integer id) {
       Optional <Course> course =  Data.coursesList.stream ()
                .filter (s ->s.getId () == id)
                .findAny ();
       course.ifPresent (Data.coursesList::remove);
    }

    public List<Course> getCoursesByStudentId (Integer id) {
        return  Data.studentList.stream ()
                .filter (s->s.getId () == id)
                .findAny ()
                .orElse (new Student ())
                .getCoursesTaken ();
    }

}
