package com.student.student_management.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_management.model.Teacher;
import com.student.student_management.repository.TeacherRepository;


@Service
public class TeacherService {

   @Autowired
   private TeacherRepository repository;

   public List<Teacher> getAllTeachers() {
      return repository.findAll();
   }

   public Teacher addTeacher(Teacher teacher) {
      return repository.save(teacher);
   }

   public Teacher getTeacherById(Long id) {
      return repository.findById(id)
              .orElseThrow(() -> new RuntimeException("Teacher not found"));
  }
   
}
