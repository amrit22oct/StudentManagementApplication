package com.student.student_management.model;

import jakarta.persistence.*;


@Entity
public class Teacher {

   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;
   private int age;
   private String subject;

   public Teacher() {}

   public Teacher(String name, int age, String subject) {
      this.name = name;
      this.age = age;
      this.subject = subject;
   }
   
   public Long getId() {
      return id;
   }
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public  int getAge() {
      return age ;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }
}
