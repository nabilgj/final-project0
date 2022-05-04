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
        System.out.println(dObj);

        // 1st check to see if the usr already logged in
        if (ctx.req.getSession().getAttribute("uid") == null) {
            ctx.status(401);
            ctx.result("You need to log in to deposit");
        } else {
            int userId = Integer.parseInt(String.valueOf(ctx.req.getSession().getAttribute("uid")));

            bs.addDeposit(dObj.balance, dObj.prevTransaction, userId);

//            User u = new User();
//            u.setUser_id(userId);

            Banking bds = new Banking();
            bds.setUsers_fk(userId);

            Banking b = om.readValue(ctx.body(), Banking.class);

            ctx.result(om.writeValueAsString("You deposited" + b.getBalance()));

        }
    };
}
