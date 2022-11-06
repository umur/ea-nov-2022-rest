package ea.nov.rest.service;

import ea.nov.rest.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAll();
    void addCourse(Course c);
}
