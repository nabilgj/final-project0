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

//   Banking Controller
   public void addDeposit(int amount, int prevTransaction, int id){
      Banking bank = new Banking();

      if (amount > 0) {
         Banking deposit = new Banking(0, amount, prevTransaction, id);
         bd.depositAmount(deposit);
//         bank.setPrevTransaction(amount);
      } else {
         System.out.println("Cant deposit negative amount");
      }

   }

}
