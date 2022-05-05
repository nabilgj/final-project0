package com.example.models;

public class Accounts {

    private int user_id;
    private String firstname;
    private String email;
    private String type;
    private int balance;

    public Accounts() {
    }

    public Accounts(int user_id, String firstname, String email, String type, int balance) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.email = email;
        this.type = type;
        this.balance = balance;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "user_id=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
