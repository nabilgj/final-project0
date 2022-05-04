package com.example.dao;

import com.example.models.Banking;
import com.example.util.ConnectionSingleton;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class BankingDao implements IBankingDao {

    private ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleTon();

    @Override
    public void depositAmount(Banking b) {
        Connection c = cs.getConnection();

        // we call our stored procedure
        try {
            // we must turn off auto commit
            c.setAutoCommit(false);

            String sql = "call banking_transaction(?, ?, ?)";
            CallableStatement call = c.prepareCall(sql);

            call.setDate(1, (Date) b.getTransaction_date());
            call.setInt(2, b.getTransaction());
            call.setInt(3, b.getUserTransaction().getUser_id());

            call.execute();

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
