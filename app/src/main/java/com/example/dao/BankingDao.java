package com.example.dao;

import com.example.models.Banking;
import com.example.models.User;
import com.example.util.ConnectionSingleton;

import java.sql.*;
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
    public void withdrawAmount(Banking b) {

    }

    @Override
    public List<Banking> checkBalance(int id) {
        return null;
    }
}
