package com.joyonta.springbootpostgrecontrollerservicerepository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//  @Query("SELECT s FROM Student WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
