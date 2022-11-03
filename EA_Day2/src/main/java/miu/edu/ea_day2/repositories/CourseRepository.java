package miu.edu.ea_day2.repositories;

import miu.edu.ea_day2.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    static{
        courses = new ArrayList<>();
        Course c1 = new Course(1, "Fundamental Programming","CS301");
        Course c2 = new Course(2, "Modern Programming","CS401");
        Course c3 = new Course(3, "Enterprise Architecture","CS545");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public void save(Course course){
        var noMatch = courses.stream().noneMatch(c-> c.getId() == course.getId());
        if (noMatch)
        {
            courses.add(course);
        }
    }

    public  void delete(int id){
       var deleteCourse = courses.stream()
                .filter(c-> c.getId() == id)
                        .findFirst().orElseThrow();
       courses.remove(deleteCourse);
    }

    public Course getById(int id){
        return courses.stream().filter(c-> c.getId() == id).findFirst().orElse(null);
    }

    public List<Course>  getAll(){
        return courses;
    }

    public void update(int id, Course course){
        var existingCourse = getById(id);
        if (existingCourse != null){
            existingCourse.setName(course.getName());
             existingCourse.setCode(course.getCode());
        }
    }


}
