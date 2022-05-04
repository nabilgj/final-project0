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

        // we call our stored procedure
        try {
            // we must turn off auto commit
//            c.setAutoCommit(false);

            String sql = "insert into banking(balance, prevTransaction, users_fk) values " +
                    "('" + b.getBalance() + "', '" + b.getPrevTransaction() + "', '" + b.getUsers_fk() + "')";

            try {
                Statement s = c.createStatement();

                // we use execute bcox insert into does not return anything
                s.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

//
//            String sql = "call banking_transaction(?, ?, ?)";
//            CallableStatement call = c.prepareCall(sql);
//            call.setInt(2, b.getTransaction());
//            call.setInt(3, b.getUserTransaction().getUser_id());
//
//            call.execute();

            // we need to set commut back to true to commit
            c.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
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
