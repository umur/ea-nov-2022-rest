package ea.nov.rest.controller;

import ea.nov.rest.model.Course;
import ea.nov.rest.service.ICourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }


    @PostMapping(value = "/add",consumes = "application/json")
    public void addCourse(@RequestParam Course c)
    {
        courseService.addCourse(c);
    }
}
