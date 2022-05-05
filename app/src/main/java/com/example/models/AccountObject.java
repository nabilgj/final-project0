package com.example.models;

public class AccountObject {

    public int user_id;
    public String firstname;
    public String email;
    public String type;
    public int balance;

    @Override
    public String toString() {
        return "AccountObject{" +
                "users_fk=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", user_id=" + balance +
                '}';
    }
}
