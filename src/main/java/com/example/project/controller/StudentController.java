package com.example.project.controller;

import com.example.project.dao.StudentRepository;
import com.example.project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    StudentRepository repo;




    @PostMapping(value = "/createStudent", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createStudent (@RequestBody Student student)
    {
        repo.save(student);
        return ResponseEntity.ok("Student ID: " + student.getId() + " added successfully");


    }

    @GetMapping(value = "/getStudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStudent(@PathVariable("id") int id)
    {
        Optional<Student> student = repo.findById(id);
            if(student.get() != null)
                return ResponseEntity.ok(student.toString());
            else
                return (ResponseEntity<String>) ResponseEntity.noContent();




    }
}
