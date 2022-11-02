package edu.miu.rest.phasetwo.repository.impl;

import edu.miu.rest.phasetwo.entity.Course;
import edu.miu.rest.phasetwo.repository.CourseRepository;
import edu.miu.rest.phasetwo.storage.EnumID;
import edu.miu.rest.phasetwo.storage.FakeDB;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public Course save(Course c) {
        Long id = FakeDB.ID.get(EnumID.C_ID);
        c.setId(id);
        FakeDB.CO_DB.add(c);
        FakeDB.ID.put(EnumID.C_ID, (id + 1));
        return c;
    }

    @Override
    public Course update(Long id, Course c) {
        Course course = findById(id);
        if(Objects.isNull(course)) {
            throw new RuntimeException("Course not found!");
        }
        BeanUtils.copyProperties(c, course, "id");
        deleteById(id);
        FakeDB.CO_DB.add(course);
        return course;
    }

    @Override
    public Boolean deleteById(Long id) {
        return FakeDB.CO_DB.removeIf(x -> Objects.equals(id, x.getId()));
    }

    @Override
    public Course findById(Long id) {
        return FakeDB.CO_DB.stream().filter(x -> Objects.equals(id, x.getId())).findFirst().orElse(null);
    }

    @Override
    public List<Course> findAll() {
        return FakeDB.CO_DB;
    }
}
