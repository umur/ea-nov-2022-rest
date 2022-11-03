package lab2.restful.repository;

import lab2.restful.models.Course;
import lab2.restful.models.Student;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class DB {
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static {
        Course c1 = new Course("CS544", "MWA", "CS544-Nov");
        Course c2 = new Course("CS544-2", "MWA-2", "CS544-Nov-2");
        courses.add(c1);
        courses.add(c2);

        Student s = new Student("001", "student1", "student1LN",
                "studentMail", "CSC", 4.0, courses);
        Student s2 = new Student("002", "student2", "student2LN",
                "studentMail", "CSC", 4.0, courses);
        students.add(s);
        students.add(s2);
    }
    public boolean addStudent(Student s){
        if(s == null){
            return false;
        }
        return students.add(s);
    }

    public Student getStudentById(String id){
        if(id == null){
            return null;
        }
        for(Student s: students){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudentById(String id){
        if(id == null ){
            return false;
        }
        Student s = this.getStudentById(id);
        if(s != null ){
            students.remove(s);
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student s, String id){
        if(s == null ){
            return false;
        }
        Student oldStudent = this.getStudentById(id);
        if(oldStudent != null){
            students.set(students.indexOf(oldStudent), s);
            return true;
        }

        return addStudent(s);
    }

    public boolean addCourse(Course c){
        if(c != null){
            return courses.add(c);
        }
        return false;
    }

    public Course getCourseById(String id){
        if(id == null){
            return null;
        }
        for(Course c: courses){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourseById(String id){
        if(id == null ){
            return false;
        }
        Course c = this.getCourseById(id);
        if(c != null ){
            courses.remove(c);
            return true;
        }
        return false;
    }

    public boolean updateCourseById(Course c, String id){
        if(c == null ){
            return false;
        }
        Course oldCourse = this.getCourseById(id);
        if(oldCourse != null){
            courses.set(courses.indexOf(oldCourse), c);
            return true;
        }
        return this.addCourse(c);
    }

    public List<Student> getStudents(){
        return students;
    }

    public List<Course> getCourses(){
        return courses;
    }


}
