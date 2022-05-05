package com.example.models;

import java.util.Date;

public class Banking {

    private int transaction_id;
    private int depositamount;
    private int balance;
//    private User userTransaction;
    private int users_fk;

    public Banking() {
    }

    public Banking(int transaction_id, int depositamount) {
        this.transaction_id = transaction_id;
        this.depositamount = depositamount;
    }

    public Banking(int transaction_id, int depositamount, int balance) {
        this.transaction_id = transaction_id;
        this.depositamount = depositamount;
        this.balance = balance;
    }

    public Banking(int transaction_id, int depositamount, int balance, int users_fk) {
        this.transaction_id = transaction_id;
        this.depositamount = depositamount;
        this.balance = balance;
        this.users_fk = users_fk;
    }


    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getDepositamount() {
        return depositamount;
    }

    public void setDepositamount(int depositamount) {
        this.depositamount = depositamount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUsers_fk() {
        return users_fk;
    }

    public void setUsers_fk(int users_fk) {
        this.users_fk = users_fk;
    }

    @Override
    public String toString() {
        return "Banking{" +
                "transaction_id=" + transaction_id +
                ", depositamount=" + depositamount +
                ", balance=" + balance +
                ", users_fk=" + users_fk +
                '}';
    }
}
