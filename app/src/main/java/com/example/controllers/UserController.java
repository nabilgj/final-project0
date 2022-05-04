package com.example.controllers;

import com.example.models.LoginObjet;
import com.example.models.RegisterObject;
import com.example.models.User;
import com.example.services.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

public class UserController {

    private UserService us;
    private ObjectMapper om;

    // will be used in main http hanlder
    public UserController(UserService us){
        this.us = us;
        this.om = new ObjectMapper();
    }

    // handlers for REST
    // implementation for handler method in main method
    public Handler handleRegister = (ctx) -> {
        RegisterObject ro = om.readValue(ctx.body(), RegisterObject.class);
        System.out.println(ro);

        us.registerUser(ro.firstName, ro.lastName, ro.email, ro.password, ro.type);

        ctx.status(201);
        ctx.result("user registered as " + ro.firstName);
    };

    public Handler handleLogin = (ctx) -> {
        LoginObjet lo = om.readValue(ctx.body(), LoginObjet.class);
        System.out.println("user logged in by " + lo.email);

        User u = us.loginUser(lo.email, lo.password);

        if (u == null) {
            ctx.status(403);
            ctx.result("Username or password is incorrect");
        } else {
            // we could also, if the user is logged in successfully, setup a session for them
            ctx.req.getSession().setAttribute("uid", ""+u.getEmail());
            ctx.result(om.writeValueAsString("user logged in by " + u.getEmail()));
        }

    };
}
