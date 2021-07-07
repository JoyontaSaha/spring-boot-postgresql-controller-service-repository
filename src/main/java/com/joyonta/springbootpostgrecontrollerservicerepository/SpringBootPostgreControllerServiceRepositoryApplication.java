package com.joyonta.springbootpostgrecontrollerservicerepository;

import com.joyonta.springbootpostgrecontrollerservicerepository.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringBootPostgreControllerServiceRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgreControllerServiceRepositoryApplication.class, args);
	}

}
