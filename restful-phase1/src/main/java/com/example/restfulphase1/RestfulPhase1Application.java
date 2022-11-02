package com.example.restfulphase1;

import com.example.restfulphase1.controller.CourseController;
import com.example.restfulphase1.controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestfulPhase1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestfulPhase1Application.class, args);
	}

}
