package com.joyonta.springbootpostgrecontrollerservicerepository.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("This Email already taken.");
        } else {
            studentRepository.save(student);
        }

    }


    public void deleteStudentById(Long studentId) {
        Optional<Student> isExists = studentRepository.findById(studentId);
        if(!isExists.isPresent()) {
            throw new IllegalStateException("Student with id " + studentId + " does not exists.");
        } else {
            studentRepository.deleteById(studentId);
        }
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists."));

        if(name != null && name.length() > 0 & !Objects.equals(name, student.getName())) {
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("This Email already taken.");
            } else {
                student.setEmail(email);
            }
        }
    }
}
