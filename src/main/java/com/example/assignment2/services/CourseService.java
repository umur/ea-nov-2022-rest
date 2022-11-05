package com.example.assignment2.services;

import com.example.assignment2.DTO.CourseDto;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    CourseDto findById(int id);
}
