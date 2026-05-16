package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity // Marks this class as a JPA entity
@DiscriminatorValue("ADMIN")  // Value stored in discriminator column for admin users
public class AdminUser extends User {
    //store admin permission level
    private String permissionLevel;
//constructor required by jpa
    public AdminUser() {
    }

    public AdminUser(String id, String name, String email, String phone, String password, String permissionLevel) {
        // parent class  constructor call
        super(id, name, email, phone, password);
        this.permissionLevel = permissionLevel;
    }
//return user type
    @Override
    public String getUserType() {
        return "ADMIN";
    }
//display admin profile information
    @Override
    public String displayProfile() {
        return getName() + " has " + permissionLevel + " access";
    }
// geter method for permision level
    public String getPermissionLevel() {
        return permissionLevel;
    }
//setter method for permission level
    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}
