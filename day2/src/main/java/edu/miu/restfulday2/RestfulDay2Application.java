package edu.miu.restfulday2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//public class RestfulDay2Application implements CommandLineRunner {
public class RestfulDay2Application {



	public static void main(String[] args) {
		SpringApplication.run(RestfulDay2Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		List<Student> studentList = StudentRepo.studentList;
//		System.out.println();
//	}
}
