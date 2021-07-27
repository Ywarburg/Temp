package com.example.project.controller;

import com.example.project.dao.StudentRepository;
import com.example.project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    StudentRepository repo;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createStudent (@RequestBody Student student)
    {
        String studentFirstName = student.getFirstName();
        String studentLastName = student.getLastName();

        if(studentFirstName == null || studentLastName == null ||
                studentFirstName.equals("") || studentLastName.equals(""))
        {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Both 'first name' and 'last name' are required");
        }

        repo.save(student);
        return ResponseEntity.ok("Student ID: " + student.getId() + " added successfully");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStudent(@PathVariable("id") int id)
    {
        Optional<Student> student = repo.findById(id);
            if(!student.isEmpty())
                return ResponseEntity.ok(student.get().toString());
            else
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("User with ID: " + id + " does not exist in the Database");
    }
}
