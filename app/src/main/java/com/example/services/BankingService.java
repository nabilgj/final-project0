package com.example.services;

import com.example.dao.IBankingDao;
import com.example.models.Banking;
import com.example.models.User;

import java.time.Instant;
import java.util.Date;

public class BankingService {

   private IBankingDao bd;

   public BankingService(IBankingDao bd) {
       this.bd = bd;
   }

   public void addDeposit(int amount, User u){

       Date d = new Date(Instant.now().toEpochMilli());

       Banking b = new Banking(0, d, amount, u);

       bd.depositAmount(b);
   }

}
