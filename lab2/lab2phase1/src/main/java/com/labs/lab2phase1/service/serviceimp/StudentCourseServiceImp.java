package com.labs.lab2phase1.service.serviceimp;

import com.labs.lab2phase1.entity.Course;
import com.labs.lab2phase1.entity.Student;
import com.labs.lab2phase1.repository.CourseRepo;
import com.labs.lab2phase1.repository.StudentRepo;
import com.labs.lab2phase1.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImp implements StudentCourseService {

    @Autowired
     private CourseRepo courseRepo;
    @Autowired
     private StudentRepo studentRepo;

    @Override
    public String assignCourse(int studentId, int courseId) {
        Student student=studentRepo.listOfStudents.stream()
                .filter(s->s.getId()==studentId)
                .findFirst().orElse(null);
        if(student==null) return "no student with id :" + studentId;

        Course course=courseRepo.listOfCourses.stream()
                .filter(c->c.getId()==courseId)
                .findFirst().orElse(null);

        if(course==null) return "no course with id :" + courseId;

        for (Course c:student.getCoursesTaken()) {
            if (c.getId()==courseId )
                return  "student" + student.getFirstName() + "already has " + course.getName();
        }
        student.addCourse(course);
        return "course " + course.getName() + " assigned to " + student.getFirstName() + "successfully";

    }

    @Override
    public List<Course> getCoursesByStudentId(int studentid) {
        Student student=studentRepo.listOfStudents.stream()
                .filter(s->s.getId()==studentid)
                .findFirst().orElse(null);
        return student.getCoursesTaken();
    }
}
