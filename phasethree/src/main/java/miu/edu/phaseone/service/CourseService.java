package miu.edu.phaseone.service;

import lombok.RequiredArgsConstructor;
import miu.edu.phaseone.dto.CourseDTO;
import miu.edu.phaseone.model.Course;
import miu.edu.phaseone.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    private final ModelMapper mapper;

    public List<CourseDTO> findAll() {
        return repository.findAll().stream().map(course -> mapper.map(course, CourseDTO.class)).collect(Collectors.toList());
    }

    public Optional<CourseDTO> findOne(Long id) {
        return repository.findOne(id).map(course -> mapper.map(course, CourseDTO.class));
    }

    public CourseDTO save(CourseDTO course) {
        return mapper.map(repository.save(mapper.map(course, Course.class)), CourseDTO.class);
    }

    public void deleteOne(Long id) {
        repository.deleteOne(id);
    }

}
