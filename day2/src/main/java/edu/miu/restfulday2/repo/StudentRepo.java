package edu.miu.restfulday2.repo;

import edu.miu.restfulday2.entity.Course;
import edu.miu.restfulday2.entity.Student;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    @Autowired
    private CourseRepo courseRepo;
    private static List<Student> studentList = new ArrayList<>();
    private static Integer currentStudentId = 2;

    @PostConstruct // initialize at after studentRepo bean is initialize / created
    public void loadStore(){
        Course course1 = courseRepo.getCourseById(1);
        List<Course> courseList = courseRepo.getCourseByListOfId(List.of(1,2));
        Student s1 = new Student(1,"James","hems","james@miu.edu", "Java",3.4, List.of(course1));
        Student s2 = new Student(2,"John","Deo","john@miu.edu", "Data",3.4, courseList);

        studentList.add(s1);
        studentList.add(s2);
    }

    public List<Student> getStudentList(){
        return studentList;
    }
    public Student save(Student student){
        studentList.add(student);
        return student;
    }

    public Student update(Student student){
        Student student1 = studentList.stream().filter(s-> s.getId().equals(student.getId())).findAny().orElseThrow(()-> new RuntimeException("Student Not Found"));
        student1.setGpa(student.getGpa());
        student1.setEmail(student.getEmail());
        student1.setMajor(student.getMajor());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setCourseTaken(student.getCourseTaken());
        return student1;
    }
    public boolean delete(Integer id) {
        Student student = studentList.stream().filter( stu -> stu.getId().equals(id)).findAny().orElseThrow(() -> new RuntimeException("ID Not Found!"));
        List<Student> tempStudent = studentList.stream().filter(s-> !s.getId().equals(id)).collect(Collectors.toList());
        studentList = tempStudent;
        return true;
    }

}
