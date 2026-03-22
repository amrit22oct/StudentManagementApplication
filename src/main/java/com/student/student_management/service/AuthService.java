package com.student.student_management.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student_management.model.Student;
import com.student.student_management.repository.StudentRepository;
import com.student.student_management.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    // public String login(String rollNo, String dob) {

    //     Student student = repository
    //             .findByRollNoAndDob(rollNo, dob)
    //             .orElseThrow(() -> new RuntimeException("Invalid credentials"));

    //     // ✅ FIX HERE
    //     return jwtUtil.generateToken(String.valueOf(student.getRollNo()));
    // }

    public Map<String, Object> login(String rollNo, String dob) {

        Student student = repository
                .findByRollNoAndDob(rollNo, dob)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    
        String token = jwtUtil.generateToken(String.valueOf(student.getRollNo()));
    
        return Map.of(
                "token", token,
                "student", student
        );
    }
}