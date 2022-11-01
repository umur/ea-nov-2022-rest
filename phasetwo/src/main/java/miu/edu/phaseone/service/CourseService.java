package miu.edu.phaseone.service;

import lombok.RequiredArgsConstructor;
import miu.edu.phaseone.dto.CourseDTO;
import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public List<CourseDTO> findAll() {
        return repository.findAll().stream().map(Course::toDTO).collect(Collectors.toList());
    }

    public Optional<CourseDTO> findOne(Long id) {
        return repository.findOne(id).map(Course::toDTO);
    }

    public CourseDTO save(CourseDTO course) {
        return repository.save(course.toEntity()).toDTO();
    }

    public void deleteOne(Long id) {
        repository.deleteOne(id);
    }

}
