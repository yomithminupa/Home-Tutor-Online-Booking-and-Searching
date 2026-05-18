package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity //marks this class jpa entity
@DiscriminatorValue("PARENT") // Stores "parent" in discriminator column
public class ParentUser extends User {
    //store atributes
    private String childName;
    private String address;
//default constructor requireb by jpa
    public ParentUser() {
    }
// create paramiterized constructor
    public ParentUser(String id, String name, String email, String phone, String password, String childName, String address) {
        //user class constructor call
        super(id, name, email, phone, password);
        this.childName = childName;
        this.address = address;
    }
    
//return user type
    @Override
    public String getUserType() {
        return "PARENT";
    }

    //display parent profile details
    @Override
    public String displayProfile() {
        return getName() + " manages tuition for " + childName;
    }

    //getter for childname
    public String getChildName() {
        return childName;
    }

    //setter for childname
    public void setChildName(String childName) {
        this.childName = childName;
    }

    //getter for address
    public String getAddress() {
        return address;
    }


    // setter for address
    public void setAddress(String address) {
        this.address = address;
    }
}
