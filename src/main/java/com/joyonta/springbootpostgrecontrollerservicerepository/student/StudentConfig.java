package com.joyonta.springbootpostgrecontrollerservicerepository.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {

        return  args -> {

            Student mariam = new Student("Mariam", "mariam.jamal@gmail.com", LocalDate.of(2001, 5, 13));

            Student alex = new Student("Alex", "alex.jamal@gmail.com", LocalDate.of(2002, 7, 19));

            Student raj = new Student("raj", "raj.jamal@gmail.com", LocalDate.of(2003, 1, 25));

            repository.saveAll(List.of(mariam, alex, raj));

        };
    }
}
