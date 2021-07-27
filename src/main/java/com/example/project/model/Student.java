package com.example.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Student() {
    }



    @Id
    private int id;
    private String firstName;
    private String lastName;




    public int getId()
    {
        return id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
