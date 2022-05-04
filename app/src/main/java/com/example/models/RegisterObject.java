package com.example.models;

public class RegisterObject {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String type;

    @Override
    public String toString() {
        return "RegisterObject{" +
                "first='" + firstName + '\'' +
                ", last='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
