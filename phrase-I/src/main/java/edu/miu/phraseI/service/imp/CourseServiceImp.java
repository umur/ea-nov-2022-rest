package edu.miu.phraseI.service.imp;

import edu.miu.phraseI.entity.Course;
import edu.miu.phraseI.repo.CourseRepo;
import edu.miu.phraseI.service.CourseService;
import edu.miu.phraseI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImp implements CourseService {

    private final CourseRepo courseRepo;

    @Autowired
    public CourseServiceImp(CourseRepo courseRepo){
        this.courseRepo=courseRepo;
    }



    public void save(Course course) {
        courseRepo.add(course);
    }

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    public Course getById(Integer id) {
        return courseRepo.getById(id);
    }

    public void update(Integer id, Course course) {
        courseRepo.update(id,course);
    }

    public void delete(Integer id) {
        courseRepo.delete(id);
    }
}
