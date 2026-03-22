package com.student.student_management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.student_management.model.Student;
import com.student.student_management.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

   @Autowired
   private StudentService service;

   @GetMapping
   public List<Student> getStudents() {
      return service.getAllStudents();
   }

   @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
    return service.getStudentById(id);
}

   @PostMapping
   public Student addStudent(@RequestBody  Student student) {
      return service.addStudent(student);
   }
   

   @DeleteMapping("/{id}")
   public void deleteStudent(@PathVariable Long id) {
      service.deleateStudent(id);
   }
   
}
