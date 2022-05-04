package com.example.dao;

import com.example.models.Banking;
import com.example.util.ConnectionSingleton;

import java.sql.*;
import java.util.List;

public class BankingDao implements IBankingDao {

    private ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleTon();

    @Override
    public void depositAmount(Banking b) {
        Connection c = cs.getConnection();

        String sql = "insert into banking(balance, prevTransaction, users_fk) values " +
                "('" + b.getBalance() + "', '" + b.getPrevTransaction() + "', '" + b.getUsers_fk() + "')";

        try {
            Statement s = c.createStatement();

            // we use execute bcox insert into does not return anything
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
