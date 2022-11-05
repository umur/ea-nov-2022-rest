package com.example.assignment2.repository;



import com.example.assignment2.DTO.StudentDto;
import com.example.assignment2.model.Course;
import com.example.assignment2.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {

 List<Student> findAll();

 public Student findById(int id);
//
//// public Object save(Student p);
//
// public void delete(int id);
//
// public void update(int id, Student p);

//
// public Course getCourseByStudenttId(int sId);

// public List<Student> getStudentbyMajor(String major) {
//     return student;
// }
 List<Student> findStudentByMajor(String major);
}
