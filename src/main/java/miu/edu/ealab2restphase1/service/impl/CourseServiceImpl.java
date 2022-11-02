package miu.edu.ealab2restphase1.service.impl;

import miu.edu.ealab2restphase1.entity.Course;
import miu.edu.ealab2restphase1.repository.CourseRepo;
import miu.edu.ealab2restphase1.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements GenService<Course> {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> findAll() {
        return courseRepo.findAllCourses();
    }

    @Override
    public Optional<Course> find(int id) {
        return courseRepo.findCourseById(id);
    }

    @Override
    public Course save(Course item) {
        return courseRepo.save(item);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }
}
