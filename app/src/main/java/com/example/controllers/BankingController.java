package com.example.controllers;

import com.example.models.Banking;
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

        // 1st check to see if the usr already logged in
        if (ctx.req.getSession().getAttribute("uid") == null) {
            ctx.status(401);
            ctx.result("You need to log in to deposit");
        } else {
            int userId = Integer.parseInt((String) ctx.req.getSession().getAttribute("uid"));

            User u = new User();
            u.setUser_id(userId);

            Banking b = om.readValue(ctx.body(), Banking.class);
            bs.addDeposit(b.getTransaction(), u);

        }
    };
}
