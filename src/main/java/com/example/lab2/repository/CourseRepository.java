package com.example.lab2.repository;


import com.example.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    static List<Course> list = new ArrayList<>();

    static {
        var c1 = new Course(1, "SA", "SA-590");
        var c2 = new Course(2, "EA", "EA-544");
        var c3 = new Course(3, "ML", "ML-584");
        list.add(c1);
        list.add(c2);
        list.add(c3);
    }

    public void add(Course c) {
        list.add(c);
    }

    public List<Course> getAll() {
        return list;
    }

    public Course one(Integer id){
        int index = this.findIndex(id);
        return list.get(index);
    }

    public void update(Integer id, Course c){
        int index = this.findIndex(id);
        list.add(index, c);
    }

    public void delete(Integer id){
        int index = this.findIndex(id);
        list.remove(index);
    }

    public Integer findIndex(Integer id){
        int index = -1;
        for (Course c: list){
            index++;
            if(c.getId() == id)
                return index;

        }
        return index;
    }
}
