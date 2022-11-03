package miu.edu.ea_day2.repositories;


import miu.edu.ea_day2.models.Course;
import miu.edu.ea_day2.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        List<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "Fundamental Programming", "CS301");
        Course c2 = new Course(2, "Modern Programming", "CS401");
        Course c3 = new Course(3, "Enterprise Architecture", "CS545");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        Student s1 = new Student(1, "john", "thp", "john@miu.edu", "compo",
                "3.65", courses);
        Student s2 = new Student(2, "Sinn", "Hei", "sin@miu.edu", "compo",
                "3.5", courses);
        Student s3 = new Student(3, "Mosoor", "theng", "theng@miu.edu", "compo",
                "3.05", courses);
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }


    public void save(Student student) {
        var noMatch = students.stream().noneMatch(c -> c.getId() == student.getId());
        if (noMatch) {
            students.add(student);
        }
    }

    public void delete(int id) {
       var deleteStudent = students.stream()
                .filter(s -> s.getId() == id)
               .findFirst().orElseThrow();
       students.remove(deleteStudent);
    }

    public Student getById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAll() {
        return students;
    }

    public void update(int id, Student student) {
        var existing = getById(id);
        if (existing != null) {
            existing.setFirstName(student.getFirstName());
            existing.setLastName(student.getLastName());
            existing.setEmail(student.getEmail());
            existing.setMajor(student.getMajor());
            existing.setGPA(student.getGPA());
            existing.getCoursesTaken().removeAll(existing.getCoursesTaken());
            existing.setCoursesTaken(student.getCoursesTaken());
        }
    }

    public List<Student> getStudentsByMajor(String major){
        var studentByMajor = students.stream()
                .filter(s-> s.getMajor().equals(major)).collect(Collectors.toList());
        return studentByMajor;
    }

    public List<Course> getCoursesByStudentId(int studentId){
      var coursesByStudentId =  students.stream().filter(s-> s.getId() == studentId).flatMap(s-> s.getCoursesTaken().stream())
                .collect(Collectors.toList());
      return coursesByStudentId;
    }

}