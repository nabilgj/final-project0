package com.example.services;

import com.example.dao.IUserDao;
import com.example.models.User;

public class UserService {

    // dependecny injection
    private IUserDao ud;

    // used in main
    public UserService(IUserDao ud) {
        this.ud = ud;
    }

    // we register a user when we create a new user using models constructor
    // used in main via accessing from postman
    // called inside UserController
    public void registerUser(String first, String last, String email, String password, String type){
        User register = new User(0, first, last, email, password, type);
        ud.createUser(register);
    }

    // called inside UserController
    public User loginUser(String email, String password) {
        // try to see if user exists in db with email
        User u = ud.readUserByEmail(email);
        if (u != null) {
            // now check password
            if(password.equals(u.getPassword())) {
                // our success
                return u;
            } else {
                // means password does not match
                return null;
            }
        }

        // also not good user does not exist
        return null;
    }
}
