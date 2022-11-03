package com.example.ModelMapper.repositories;

import com.example.ModelMapper.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    List<Student> findStudentsByMajor(String major);
}
