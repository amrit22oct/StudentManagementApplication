package com.student.student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_management.model.Student;
import com.student.student_management.repository.StudentRepository;


@Service
public class StudentService {

   @Autowired
   private StudentRepository repository;
   
   public List<Student> getAllStudents() {
      return repository.findAll();
   }

   public Student addStudent(Student student) {
      return repository.save(student);
   }

   public Student getStudentById(Long id) {
      return repository.findById(id)
          .orElseThrow(() -> new RuntimeException("Student not found"));
  }

   public void deleateStudent(Long id) {
      repository.deleteById(id);
   }
}
