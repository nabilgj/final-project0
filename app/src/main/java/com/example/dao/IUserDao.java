package com.example.dao;

import com.example.models.User;

import java.util.List;

// implemented in UserDao Class
public interface IUserDao {

    // implemented inside UserDao
    public void createUser(User u);

    public User readAllUsers(String type);

    public User readUserByEmail(String email);

    public User updateUser(User u);

    public void deleteUser(User u);
}
