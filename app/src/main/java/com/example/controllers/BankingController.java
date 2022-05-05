package com.example.controllers;

import com.example.models.*;

import com.example.services.BankingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;
import org.checkerframework.checker.units.qual.A;

import com.example.models.Accounts;

import java.util.ArrayList;


public class BankingController {

    private BankingService bs;
    private ObjectMapper om;

    public BankingController(BankingService bs) {
        this.bs = bs;
        this.om = new ObjectMapper();
    }

    public Handler handleDepositAmount = (ctx) -> {

        DepositObject dObj = om.readValue(ctx.body(), DepositObject.class);

        int prevBalance = 0;

        // 1st check to see if the usr already logged in
        if (ctx.req.getSession().getAttribute("uid") == null) {
            ctx.status(401);
            ctx.result("You need to log in to your RevatureBank Account to deposit");
        } else {
            int userId = Integer.parseInt(String.valueOf(ctx.req.getSession().getAttribute("uid")));

            if (dObj.depositamount < 0) {
                ctx.status(403);
                ctx.result("Oops! you can not deposit any amount below zero");
            } else {
                Banking bds = new Banking();
                prevBalance = prevBalance + dObj.depositamount;
                bds.setUsers_fk(userId);

                if(bds.getUsers_fk() == userId && bds.getBalance() != prevBalance) {
                    bs.addDeposit(dObj.depositamount, prevBalance, userId);
                    bds.setBalance(prevBalance);
                }

                Banking b = om.readValue(ctx.body(), Banking.class);
                ctx.result(om.writeValueAsString("You deposited $" + b.getDepositamount()));
            }
        }
    };

    public Handler handleWithDrawl = (ctx) -> {
        DepositObject dobj = om.readValue(ctx.body(), DepositObject.class);
        int userId = Integer.parseInt(String.valueOf(ctx.req.getSession().getAttribute("uid")));
        Banking newB = new Banking(dobj.depositamount, userId);

        int newBalance = newB.getBalance() - dobj.depositamount;
        System.out.println("coming from line 63 inside handleWithDrawl " + newB);
        System.out.println("coming from line 64 inside handleWithDrawl " + newBalance);

        // 1st check to see if the usr already logged in
        if (ctx.req.getSession().getAttribute("uid") == null) {
            ctx.status(401);
            ctx.result("You need to log in to your RevatureBank Account to withdraw");
        } else {

            if (newB.getDepositamount() < 0) {
                ctx.status(403);
                ctx.result("Oops! you do not have sufficient balance.");
            } else {
                Banking bds = new Banking();
                bds.setUsers_fk(userId);

                if(bds.getUsers_fk() == userId && bds.getBalance() != newBalance) {
                    bs.deductAccount(dobj.depositamount, userId);
                    bds.setBalance(newBalance);
                }

                Banking b = om.readValue(ctx.body(), Banking.class);
                ctx.result(om.writeValueAsString("You withdraw $" + dobj.depositamount));
            }
        }
    };

    public Handler handleAllAccounts = (ctx) -> {
        AccountObject aObj = om.readValue(ctx.body(), AccountObject.class);
        ArrayList<Accounts> accList = new ArrayList<>();

        int userId = Integer.parseInt(String.valueOf(ctx.req.getSession().getAttribute("uid")));

        System.out.println("coming from line 93 " + userId);

        if (aObj.user_id != userId) {
            bs.seeAccounts(aObj.user_id);
            System.out.println("coming from line 97 " + bs.seeAccounts(aObj.user_id));
            ctx.status(200);
            ctx.result(om.writeValueAsString(bs.seeAccounts(aObj.user_id)));
        }
    };
}
