package com.example.restfulphase2.repository;

import com.example.restfulphase2.entity.Course;
import com.example.restfulphase2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository extends CrudRepository<Student>{

    public StudentRepository(){
        super();
        list = new ArrayList<Student>();
        list.add(new Student("1","Jhon","Doe","jhon@miu.edu","ComPro","4.0",new CourseRepository().getAll().stream().map(Course::getId).toList()));
        list.add(new Student("2","Siam","Biswas","siam@miu.edu","MSD","4.0",new CourseRepository().getAll().stream().map(Course::getId).toList()));
    }

    public List<Student> getStudentsByMajor(String major){
        return list.stream().filter(data -> data.getMajor().equals(major)).toList();
    }

    public List<String> getCoursesByStudentId(String id){
        return list.stream().filter(data -> data.getId().equals(id))
                .flatMap(data -> data.getCoursesTaken().stream()).collect(Collectors.toList());
    }
}
