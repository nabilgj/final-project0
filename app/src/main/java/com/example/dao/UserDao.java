package com.example.dao;

import com.example.models.User;
import com.example.util.ConnectionSingleton;

import java.sql.*;
import java.util.List;

public class UserDao implements IUserDao {


    // coming from ConnectionSingleton util file
    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleTon();

    // used in UserService inside registerUser
    @Override
    public void createUser(User u) {
        // create a user, we must get our connection
        Connection c = cs.getConnection();

        String sql = "insert into users (firstname, lastname, email, password, type, approved) values " +
                    "('" + u.getFirstName() + "', '" + u.getLastName() + "', '" + u.getEmail() + "', '" + u.getPassword() + "', '" +  u.getType() + "'," +  (Boolean) u.getApproved()  + ")";

        // create a statement and execute it
        try {
            Statement s = c.createStatement();

            // we use execute bcox insert into does not return anything
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    // used in UserService inside
    @Override
    public List<User> readAllUsers() {
        return null;
    }

    @Override
    public User readUserByEmail(String email) {
        // get our db connection
        Connection c = cs.getConnection();

        // sql
        String sql = "select * FROM users where email = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, email);

            // we use executeQuery bcox select returns data
            ResultSet rs = ps.executeQuery();

            // now loop through resultSet

            User loggedIn = null;
            while(rs.next()) {
                loggedIn = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7) );
            }

            return loggedIn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw null;
        }

    }

    @Override
    public User updateUser(User u) {
        Connection c = cs.getConnection();

        String sql = "UPDATE users SET type = ? " +
                "WHERE user_id = ?";

        try {
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, u.getType());
            p.setInt(2, u.getUser_id());

            p.execute();
            return u;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteUser(User u) {
        Connection c = cs.getConnection();

        String sql = "DELETE FROM users WHERE user_id= ?";

        try {
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, u.getUser_id());
            p.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
