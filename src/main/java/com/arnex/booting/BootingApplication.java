package com.arnex.booting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arnex.booting.data.repository.EmployeeRepository;
import com.arnex.booting.data.repository.RoomRepository;

@SpringBootApplication
public class BootingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.findAll().forEach(System.out::println);
		};
	}

}
