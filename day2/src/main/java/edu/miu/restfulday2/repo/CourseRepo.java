package edu.miu.restfulday2.repo;

import edu.miu.restfulday2.entity.Course;
import edu.miu.restfulday2.entity.dto.CourseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courseList = new ArrayList<>();
    private static Integer currentCourseId = 2;
    static {
        Course p1 = new Course(1,"FPP", "CS390");
        Course p2 = new Course(2,"MPP", "CS401");

        courseList.add(p1);
        courseList.add(p2);
    }

    public List<Course> getCourseList(){
        return courseList;
    }

    public Course save(Course course){
        courseList.add(course);
        return course;
    }


    public Course update(Course course){
        Course found = getCourseById(course.getId());
//        found.setId(course.getId());
        found.setName(course.getName());
        found.setCode(course.getCode());
        return found;

    }


    public boolean deleteById(Integer id){
        Course found = getCourseById(id);
//        if (!found) return false;
        courseList.remove(courseList.indexOf(found));
        return true;
    }


    public Course getCourseById(Integer id) {
        List<Course> foundCourse =  courseList.stream().filter(course -> course.getId().equals(id)).collect(Collectors.toList());
        if(foundCourse.size() != 1) {
            throw new IllegalStateException("Error!, Course Not found");
        }
        return foundCourse.get(0);
    }

    public List<Course> getCourseByListOfId(List<Integer> ids) {
        List<Course> foundCourseList =  courseList.stream()
                .filter(course -> {

                    for(int inputId: ids) {
                        if (course.getId().equals(inputId)) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return foundCourseList;
    }
}
