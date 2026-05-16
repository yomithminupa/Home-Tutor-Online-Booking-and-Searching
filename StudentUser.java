package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
    //identifies this entity as student
@DiscriminatorValue("STUDENT")
public class StudentUser extends User {
    private String grade;
    private String address;

    public StudentUser() {
    }
//constructor to initialize student details
    public StudentUser(String id, String name, String email, String phone, String password, String grade, String address) {
        //call parent class constructor
        super(id, name, email, phone, password);
        this.grade = grade;
        this.address = address;
    }

    //return  user type
    @Override
    public String getUserType() {
        return "STUDENT";
    }

    //display student profile
    @Override
    public String displayProfile() {
        return getName() + " studies in " + grade;
    }

    //getter for grade
    public String getGrade() {
        return grade;
    }

    //setter for grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    //getter for address
    public String getAddress() {
        return address;
    }

    //setter for address
    public void setAddress(String address) {
        this.address = address;
    }
}
