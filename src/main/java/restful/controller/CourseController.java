package lab2.restful.controller;


import lab2.restful.models.Course;
import lab2.restful.models.Student;
import lab2.restful.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id){
        return this.courseService.getCourseById(id);
    }

    @PostMapping
    public String addCourse(@RequestBody Course c){
        boolean success = this.courseService.addCourse(c);
        if(success){
            return "successfully added course";
        }
        else{
            return "unable to add course";
        }
    }

    @PutMapping("/{id}")
    public String updateCourse(@RequestBody Course c, @PathVariable String id){
        boolean success = this.courseService.updateCourseById(c, id);
        if(success){
            return "successfully updated course";
        }
        else{
            return "unable to update course";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id){
        boolean success = this.courseService.deleteCourseById(id);
        if(success){
            return "successfully deleted course";
        }
        else{
            return "unable to delete course";
        }
    }
}
