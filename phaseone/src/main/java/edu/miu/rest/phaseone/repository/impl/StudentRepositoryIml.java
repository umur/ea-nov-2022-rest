package edu.miu.rest.phaseone.repository.impl;

import edu.miu.rest.phaseone.entity.Course;
import edu.miu.rest.phaseone.entity.Student;
import edu.miu.rest.phaseone.repository.StudentRepository;
import edu.miu.rest.phaseone.storage.EnumID;
import edu.miu.rest.phaseone.storage.FakeDB;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Repository
public class StudentRepositoryIml implements StudentRepository {
    @Override
    public List<Student> findStudentsByMajor(String major) {
        return FakeDB.STU_DB.stream().filter(x -> major.equals(x.getMajor()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findCoursesByStudent(Long studentId) {
        return FakeDB.STU_DB.stream().filter(x -> Objects.equals(studentId, x.getId()))
                .flatMap(x -> x.getCourses().stream()).collect(Collectors.toList());
    }

    @Override
    public Student save(Student s) {
        Long id = FakeDB.ID.get(EnumID.S_ID);
        s.setId(id);
        FakeDB.STU_DB.add(s);
        FakeDB.ID.put(EnumID.S_ID, (id + 1));
        return s;
    }

    @Override
    public Student update(Long id, Student s) {
        Student student = findById(id);
        if (Objects.isNull(student)) {
            throw new RuntimeException("Student not found!");
        }
        BeanUtils.copyProperties(s, student, "id");
        deleteById(id);
        FakeDB.STU_DB.add(student);
        return student;
    }

    @Override
    public Boolean deleteById(Long id) {
        return FakeDB.STU_DB.removeIf(x -> Objects.equals(id, x.getId()));
    }

    @Override
    public Student findById(Long id) {
        return FakeDB.STU_DB.stream().filter(x -> Objects.equals(id, x.getId())).findFirst().orElse(null);
    }
}
