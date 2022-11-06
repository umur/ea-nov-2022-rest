package ea.nov.rest.repository;

import ea.nov.rest.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course c)
    {
        courseList.add(c);
    }
}
