package com.example.services;

import com.example.dao.IBankingDao;
import com.example.models.Accounts;
import com.example.models.Banking;
import com.example.models.User;
import org.checkerframework.checker.units.qual.A;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class BankingService {

   private IBankingDao bd;

   public BankingService(IBankingDao bd) {
       this.bd = bd;
   }


   public void addDeposit(int amount, int balance, int id){

      Banking bank = new Banking();

      if (amount > 0) {
         Banking deposit = new Banking(0, amount, balance, id);

         bd.depositIntoAccount(deposit);

         // here balance is zero
         System.out.println("this is prevBal " + deposit.getDepositamount());
      } else {
         System.out.println("Cant deposit negative amount");
      }

   }

   public void deductAccount(int amount, int balance, int id){

      Banking bank = new Banking();

      if (amount > 0) {
         Banking deposit = new Banking(0, amount, balance, id);
         bd.withdrawAmount(deposit);

         // here balance is zero

      } else {
         System.out.println("Cant withdraw negative amount");
      }

   }



   public Accounts seeAccounts(int id) {
      Accounts au = bd.checkAccounts(id);
//      Accounts accCom = new Accounts();

      System.out.println("coming from line 40 seeAccounts " + au.getFirstname());

      if (au != null) {
         // now check password
         if(au.getUser_id() == id) {
            // our success
            Accounts acc = new Accounts(au.getUser_id(), au.getFirstname(), au.getEmail(), au.getType(), au.getBalance());
            return acc;
         } else {
            // means password does not match
            return null;
         }
      }

   return au;
   }



}
