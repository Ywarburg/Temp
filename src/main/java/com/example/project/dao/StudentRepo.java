package com.example.project.dao;

import com.example.project.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer>
{

}
