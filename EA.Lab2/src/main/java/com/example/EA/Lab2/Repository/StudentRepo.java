package com.example.EA.Lab2.Repository;

import com.example.EA.Lab2.Entity.Course;
import com.example.EA.Lab2.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByMajor(String major);


}
