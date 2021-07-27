package com.example.project.controller;

import com.example.project.dao.StudentRepo;
import com.example.project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    StudentRepo repo;




    @PostMapping(value = "/createStudent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createStudent (Student student)
    {
        try {
            repo.save(student);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("e.getMessage()");
        }

        return ResponseEntity.ok("Student ID: " + student.getId() + "added successfully");
    }

    @GetMapping(value = "/getStudent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStudent(int id)
    {
        Optional<Student> student;

        try {
            student = repo.findById(id);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("e.getMessage()");
        }

        return ResponseEntity.ok("Student ID: " + student.toString());
    }
}
