package miu.edu.ea_day2.services;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day2.repositories.CourseRepository;
import miu.edu.ea_day2.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository ;

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void delete(int id) {
        courseRepository.delete(id);
    }

    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    public Course getById(int id) {
        return courseRepository.getById(id);
    }

    public void update(int id, Course course) {
        courseRepository.update(id,course);
    }


}
