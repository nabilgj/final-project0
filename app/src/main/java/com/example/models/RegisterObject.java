package com.example.models;

public class RegisterObject {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String type;

    public String approved;



    @Override
    public String toString() {
        return "RegisterObject{" +
                "first='" + firstName + '\'' +
                ", last='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", approved='" + approved + '\'' +
                '}';
    }
}
