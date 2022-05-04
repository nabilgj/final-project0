package com.example.models;

public class DepositObject {

    public int balance;
    public int prevTransaction;


    @Override
    public String toString() {
        return "DepositObject{" +
                "balance=" + balance +
                ", prevTransaction=" + prevTransaction +
                '}';
    }
}
