package com.labs.lab2phase1.service;

import com.labs.lab2phase1.entity.Course;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentCourseService {

String assignCourse (int studentId,int courseId);

List<Course> getCoursesByStudentId( int studentid);

}
