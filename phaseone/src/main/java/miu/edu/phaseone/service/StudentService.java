package miu.edu.phaseone.service;

import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public List<Course> findAll() {
        return repository.findAll();
    }

    public Optional<Course> findOne(Long id) {
        return repository.findOne(id);
    }

    public Course save(Course course) {
        return repository.save(course);
    }

    public void deleteOne(Long id) {
        repository.deleteOne(id);
    }

}
