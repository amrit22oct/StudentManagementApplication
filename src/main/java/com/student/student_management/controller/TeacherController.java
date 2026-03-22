package com.student.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.student_management.model.Teacher;
import com.student.student_management.service.TeacherService;




@RestController
@RequestMapping("/teacher")
public class TeacherController {

   @Autowired
   private TeacherService service;

   @GetMapping
   public List<Teacher> getTeachers() {
      return service.getAllTeachers();
   }

   @GetMapping("/{id}")
   public Teacher getTeacherById(@PathVariable Long id) {
      return service.getTeacherById(id);
   }

   @PostMapping
   public Teacher addTeacher(@RequestBody Teacher teacher) {
      return service.addTeacher(teacher);
   }
   
}
