package com.example.controllers;

import com.example.models.Banking;
import com.example.models.DepositObject;
import com.example.models.RegisterObject;
import com.example.models.User;
import com.example.services.BankingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;


public class BankingController {

    private BankingService bs;
    private ObjectMapper om;

    public BankingController(BankingService bs) {
        this.bs = bs;
        this.om = new ObjectMapper();
    }

    public Handler handleDepositAmount = (ctx) -> {

        DepositObject dObj = om.readValue(ctx.body(), DepositObject.class);

        // 1st check to see if the usr already logged in
        if (ctx.req.getSession().getAttribute("uid") == null) {
            ctx.status(401);
            ctx.result("You need to log in to your Revature Account to deposit");
        } else {
            int userId = Integer.parseInt(String.valueOf(ctx.req.getSession().getAttribute("uid")));

            if (dObj.balance < 0) {
                ctx.status(403);
                ctx.result("Oops! you can not deposit any amount below zero --- zero is for Project0");
            } else {
                Banking bds = new Banking();
                int prevBalance = dObj.balance;

                bds.setUsers_fk(userId);

                if(bds.getUsers_fk() == userId && bds.getPrevTransaction() != prevBalance) {
                    bs.addDeposit(dObj.balance, prevBalance, userId);
                    bds.setPrevTransaction(prevBalance + dObj.balance);
                }


                Banking b = om.readValue(ctx.body(), Banking.class);
                ctx.result(om.writeValueAsString("You deposited $" + b.getBalance()));
            }

        }
    };
}
