package lab2.restful.service;


import lab2.restful.models.Course;
import lab2.restful.repository.DB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    DB db;

    public CourseService(DB db){
        this.db = db;
    }

    public List<Course> getCourses(){
        return this.db.getCourses();
    }

    public Course getCourseById(String id){
        return this.db.getCourseById(id);
    }

    public boolean addCourse(Course c){
        return this.db.addCourse(c);
    }

    public boolean updateCourseById(Course c, String id){
        return this.db.updateCourseById(c, id);
    }

    public boolean deleteCourseById(String id){
        return this.db.deleteCourseById(id);
    }
}
