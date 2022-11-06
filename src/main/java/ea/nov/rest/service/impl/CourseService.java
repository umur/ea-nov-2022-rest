package ea.nov.rest.service.impl;

import ea.nov.rest.model.Course;
import ea.nov.rest.repository.CourseRepo;
import ea.nov.rest.repository.StudentRepo;
import ea.nov.rest.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Override
    public List<Course> getAll() {
        return courseRepo.getCourseList();
    }

    @Override
    public void addCourse(Course c) {
        courseRepo.addCourse(c);
    }
}
