package com.student.student_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.student_management.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
   Optional<Student> findByRollNoAndDob(String rollNo, String dob);
}