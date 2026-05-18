package com.example.hometutor.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity // mark this class as a database entity
@Table(name = "app_users")//table name in database
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    // all subclasses stored in one table
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)

    // Column used to distinguish user types,admin,student,parent
public abstract class User implements IdentifiableEntity {
    @Id // primary key
    private String id;

    //name cant be null
    @Column(nullable = false)
    private String name;

    //email cant be null
    @Column(nullable = false)
    private String email;

    private String phone;
    private String password;

    // default constructor required jpa
    protected User() {
    }

    // Constructor to initialize common user fields
    protected User(String id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // subclass define its user type
    public abstract String getUserType();

    // default profile display. it can be override
    public String displayProfile() {
        return name + " - " + getUserType();
    }

    // return uniqe id
    @Override
    public String getId() {
        return id;
    }

    // create  setters and getters
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
