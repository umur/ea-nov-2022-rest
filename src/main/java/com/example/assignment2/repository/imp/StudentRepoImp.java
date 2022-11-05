//package com.example.assignment2.repository.imp;
//
//import com.example.assignment2.model.Course;
//import com.example.assignment2.model.Student;
//import com.example.assignment2.repository.StudentRepo;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Repository
//public class StudentRepoImp implements StudentRepo {
//
//    static List<Student> student= new ArrayList<>();
//
//    static List<Course> courses1= new ArrayList<>();
//
//    static {
//        //var s6 =new Student(1,firstname:"ali")
//
//        var c1= new Course(1, "SA", "590");
//        var c2= new Course(2, "ML", "588");
//
//        courses1.add(c1);
//        courses1.add(c2);
//
//    }
//    static List<Course> courses2= new ArrayList<>();
//
//    static {
//        var c3= new Course(3, "FPP", "390");
//        var c4= new Course(4, "MPP", "430");
//        courses2.add(c3);
//        courses2.add(c4);
//
//    }
//
//    static List<Course> courses3= new ArrayList<>();
//
//    static {
//        //var s6 =new Student(1,firstname:"ali")
//        var c6 = new Course(1,"EA","580");
//        var c5= new Course(5,"ALG","490");
//
//        courses3.add(c5);
//        courses3.add(c6);
//    }
//    static {
//        //var s6 =new Student(1,firstname:"ali")
//        var s6 = new Student(1,"john","tomas","kdk@gmail.com","MBA",3.2,"23",courses1);
//        var s1= new Student(1, "ali", "kamyab","kamyabali7@gmail.com","BCA",3.5, "EA",courses2);
//        var s2= new Student(2, "makdes", "makdes","kamyabali7@gmail.com","MBA",3.5, "SA",courses3);
//        var s3= new Student(3, "Hamida", "makdes","kamyabali7@gmail.com","BBA",4.0, "FPP",courses2);
//        var s4= new Student(4, "Tomas", "makdes","kamyabali7@gmail.com","BBA",3.1, "EA",courses3);
//        var s5= new Student(5,"ali","marjan","kamyab@gmail.com","csc",3.9,"ML",courses1);
//        student.add(s1);
//        student.add(s2);
//        student.add(s3);
//        student.add(s4);
//        student.add(s6);
//    }
//
//    @Override
//    public List<Student> findAll() {
//        return student;
//    }
//
//    @Override
//    public Student getById(int id) {
//        return null;
//    }
//
//    @Override
//    public Object save(Student p) {
//
//        return null;
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }
//
//    @Override
//    public void update(int id, Student p) {
//
//    }
//
//    @Override
//    public Course getCourseByStudenttId(int sId) {
//        return null;
//    }
//
//    @Override
//    public List<Student> getStudentbyMajor(String major) {
////        return student.stream()
////                .filter(m -> m.getMajor()==major)
////                .collect(Collectors.toList());
//       //System.out.println("this"+major);
//        return student.stream().filter(m->m.getMajor()==major).collect(Collectors.toList());
//    }
//}
