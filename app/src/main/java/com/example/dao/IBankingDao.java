package com.example.dao;

import com.example.models.Accounts;
import com.example.models.Banking;

import java.util.List;

public interface IBankingDao {

    public void depositIntoAccount(Banking b);
    public Banking withdrawAmount(Banking b);
    public Accounts checkAccounts(int id);
}
