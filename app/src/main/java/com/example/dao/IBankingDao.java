package com.example.dao;

import com.example.models.Banking;

import java.util.List;

public interface IBankingDao {

    public void depositIntoAccount(Banking b);
    public void withdrawAmount(Banking b);
    public List<Banking> checkBalance(int id);
}
