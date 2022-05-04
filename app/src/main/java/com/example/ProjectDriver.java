/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example;

import com.example.controllers.UserController;
import com.example.dao.IUserDao;
import com.example.dao.UserDao;
import com.example.services.UserService;
import com.example.util.ConnectionSingleton;
import io.javalin.Javalin;

import java.sql.Connection;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ProjectDriver {

    public static void main(String[] args) {

        IUserDao ud = new UserDao();
        UserService us = new UserService(ud);

        // this is constructor call for Controller that handles http handler
        UserController uc = new UserController(us);

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        });

        // set up routes for http handlers
        // controller handles logic for api request for implementation
        app.routes(() -> {
            path("users", () -> {
               post("/register", uc.handleRegister);
               post("/login", uc.handleLogin);
               put("/userupdate", uc.handleUpdateUser);
               delete("/userdelete/{id}", uc.handleDeleteUser);
            });
        });


        app.start(8000);
    }
}
