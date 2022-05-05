package com.example.models;

import java.util.Date;

public class Banking {

    private int transaction_id;
    private int balance;
    private int prevTransaction;
//    private User userTransaction;
    private int users_fk;

    public Banking() {
    }

    public Banking(int transaction_id, int balance, int prevTransaction, int users_fk) {
        this.transaction_id = transaction_id;
        this.balance = balance;
        this.prevTransaction = prevTransaction;
        this.users_fk = users_fk;
    }

    public Banking(int transaction_id, int balance) {
        this.transaction_id = transaction_id;
        this.balance = balance;
    }

    public Banking(int transaction_id, int balance, int prevTransaction) {
        this.transaction_id = transaction_id;
        this.balance = balance;
        this.prevTransaction = prevTransaction;
    }



    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPrevTransaction() {
        return prevTransaction;
    }

    public void setPrevTransaction(int prevTransaction) {
        this.prevTransaction = prevTransaction;
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
                ", balance=" + balance +
                ", prevTransaction=" + prevTransaction +
                ", users_fk=" + users_fk +
                '}';
    }
}
