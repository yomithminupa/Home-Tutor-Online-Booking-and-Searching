package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminUser extends User {
    private String permissionLevel;

    public AdminUser() {
    }

    public AdminUser(String id, String name, String email, String phone, String password, String permissionLevel) {
        super(id, name, email, phone, password);
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String getUserType() {
        return "ADMIN";
    }

    @Override
    public String displayProfile() {
        return getName() + " has " + permissionLevel + " access";
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}
