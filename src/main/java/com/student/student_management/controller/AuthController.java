package com.student.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.student_management.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    // @PostMapping("/login")
    // public Map<String, String> login(@RequestBody Map<String, String> request) {

    //     String rollNo = request.get("rollNo");
    //     String dob = request.get("dob");

    //     String token = service.login(rollNo, dob);

    //     return Map.of("token", token);
    // }

    @PostMapping("/login")
public Map<String, Object> login(@RequestBody Map<String, String> request) {

    String rollNo = request.get("rollNo");
    String dob = request.get("dob");

    return service.login(rollNo, dob);
}
}