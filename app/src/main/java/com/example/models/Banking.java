package com.example.models;

import java.util.Date;

public class Banking {

    private int transaction_id;
    private Date transaction_date;
    private int transaction;
//    private User userTransaction;
    private User users_fk;

    public Banking() {
    }

    public Banking(int transaction_id, Date transaction_date, int transaction, User users_fk) {
        this.transaction_id = transaction_id;
        this.transaction_date = transaction_date;
        this.transaction = transaction;
        this.users_fk = users_fk;
    }

    public Banking(int transaction_id, Date transaction_date, int transaction) {
        this.transaction_id = transaction_id;
        this.transaction_date = transaction_date;
        this.transaction = transaction;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public User getUserTransaction() {
        return users_fk;
    }

    public void setUserTransaction(User users_fk) {
        this.users_fk = users_fk;
    }

    @Override
    public String toString() {
        return "BankingTransaction{" +
                "transaction_id=" + transaction_id +
                ", transaction_date=" + transaction_date +
                ", transaction=" + transaction +
                ", userTransaction=" + users_fk +
                '}';
    }
}
