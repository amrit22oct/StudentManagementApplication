package com.student.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.student_management.model.Teacher;

public interface  TeacherRepository extends JpaRepository<Teacher, Long> {
   
}
