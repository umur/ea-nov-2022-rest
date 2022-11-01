package miu.edu.phaseone;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhaseoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhaseoneApplication.class, args);
	}

	@Bean
	public ModelMapper setup() {
		return new ModelMapper();
	}
}
