package com.example.dao;

import com.example.models.Accounts;
import com.example.models.Banking;
import com.example.models.User;
import com.example.util.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankingDao implements IBankingDao {

    private ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleTon();

    @Override
    public void depositIntoAccount(Banking b) {
        Connection c = cs.getConnection();
        String sql = "insert into banking(depositamount, balance, users_fk) values " +
                "('" + b.getDepositamount() + "', '" + b.getBalance() + "', '" + b.getUsers_fk() + "')";

        try {
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Banking withdrawAmount(Banking b) {
        Connection c = cs.getConnection();
        String sql = "select * from banking b where b.users_fk = " + b.getUsers_fk();
        System.out.println("coming from line 35 inside withdrawAmount " + sql);

        try {
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);

            while(res.next()) {
                System.out.println("coming from line 42 checkAccounts " + res);
                Banking ba = new Banking(res.getInt("transaction_id"), res.getInt("depositamount"), res.getInt("balance"), res.getInt("users_fk"));
                System.out.println("coming from line 44 withdrawAmount " + ba);
                return ba;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Accounts checkAccounts(int id) {

        Connection c = cs.getConnection();
        String sql = "select * from users u, banking b where u.user_id = " + id;

        System.out.println("coming from line 50 " + sql);

        try {
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);

            while(res.next()) {
                Accounts accounts = new Accounts(res.getInt("user_id"), res.getString("firstname"), res.getString("email"), res.getString("type"), res.getInt("balance"));
                System.out.println("coming from line 50 checkAccounts " + accounts);
                return accounts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return null;
    }
}
