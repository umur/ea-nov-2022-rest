package com.example.assignment2.services.impl;


import com.example.assignment2.DTO.CourseDto;
import com.example.assignment2.repository.CourseRepo;
import com.example.assignment2.services.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {
    @Autowired
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;
    @Override
    public CourseDto findById(int id) {
        var data = courseRepo.findById(id).get();
        var result=modelMapper.map(data,CourseDto.class);
        return result;
    }
}
