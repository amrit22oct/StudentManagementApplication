package com.student.student_management.middleware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.student.student_management.security.JwtUtil;

@Component
public class StudentInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Incoming Request: " + request.getRequestURI());

        // Skip login endpoint
        if (request.getRequestURI().contains("/auth/login")) {
            return true;
        }

        String authHeader = request.getHeader("Authorization");

        // Check header format
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(401);
            response.getWriter().write("Missing or invalid Authorization header");
            return false;
        }

        String token = authHeader.substring(7);

        System.out.println("Auth Header: " + authHeader);
System.out.println("Extracted Token: " + token);

        try {
            if (!jwtUtil.validateToken(token)) {
                response.setStatus(401);
                response.getWriter().write("Token expired or invalid");
                return false;
            }
            
            String rollNo = jwtUtil.extractRollNo(token);
            System.out.println("Authenticated Student: " + rollNo);
        } catch (Exception e) {
            response.setStatus(401);
            response.getWriter().write("Invalid token");
            return false;
        }

        return true;
    }
}