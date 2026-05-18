package com.example.hometutor.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity  // mark this class jpa entity
    
@Table(name = "app_users") // Maps this entity to the app_users table
    
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//Defines inheritance strategy and all subclasses use one table
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING) // use the column identify subclass type

    //abstract base class for all system users.
public abstract class User implements IdentifiableEntity {

    // user primary key
    @Id
    private String id;
    
   // name cant be null
    @Column(nullable = false)
    private String name;
    
     // email cant be null
    @Column(nullable = false)
    private String email;

    //optional contact number and loging password
    private String phone;
    private String password;

    
    // default constructor required by jpa
    protected User() {
    }

    //initialize user details
    protected User(String id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    
      //abstract method implemented by subclasses
    public abstract String getUserType();

     // return profile info
    public String displayProfile() {
        return name + " - " + getUserType();
    }

     // getters and setters use for return and set below details
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
