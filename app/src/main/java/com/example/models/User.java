package com.example.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String type;

    private String approved;

    public User() {
    }

    public User(String approved) {
        this.approved = approved;
    }

    public User(int userid, String firstname, String lastname, String email, String password, String type) {
        this.userId = userid;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    // a special contructor for use in the dao

    public User(int user_id, String firstname, String lastname, String email, String password, String type, String approved) {
        this.userId = user_id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.type = type;
        this.approved = approved;
    }

    // getters and setters

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int user_id) {
        this.userId = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApproved() { return approved; }

    public void setApproved(String approved) {
        this.approved = approved;
    }



    // toString

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", approved='" + approved + '\'' +
                '}';
    }
}
