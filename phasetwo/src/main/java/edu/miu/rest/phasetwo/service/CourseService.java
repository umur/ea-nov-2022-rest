package edu.miu.rest.phasetwo.service;

import edu.miu.rest.phasetwo.dtos.CourseDTO;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
public interface CourseService {
    CourseDTO save(CourseDTO c);

    CourseDTO update(Long id, CourseDTO c);

    Boolean deleteById(Long id);

    CourseDTO findById(Long id);

    List<CourseDTO> findAll();
}
